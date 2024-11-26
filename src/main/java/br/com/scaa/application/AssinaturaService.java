package br.com.scaa.application;

import br.com.scaa.domain.AplicativoModel;
import br.com.scaa.domain.AssinaturaCacheModel;
import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.ClienteModel;
import br.com.scaa.domain.repository.IAssinaturaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AssinaturaService {

    private final IAssinaturaRepository assinaturaRepository;
    private final ClienteService clienteService;
    private final AplicativoService aplicativoService;
    private final RabbitTemplate rabbitTemplate; // RabbitMQ template
    private final RestTemplate restTemplate;    // HTTP client para AssCache

    @Value("${asscache.url}") // URL do AssCache (defina em application.properties)
    private String assCacheUrl;

    @Value("${rabbitmq.exchange.assinatura}")
    private String assinaturaExchange;

    @Value("${rabbitmq.routingkey.assinatura}")
    private String assinaturaRoutingKey;

    public AssinaturaService(
            IAssinaturaRepository assinaturaRepository,
            AplicativoService aplicativoService,
            ClienteService clienteService,
            RabbitTemplate rabbitTemplate,
            RestTemplate restTemplate) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoService = aplicativoService;
        this.clienteService = clienteService;
        this.rabbitTemplate = rabbitTemplate;
        this.restTemplate = restTemplate;
    }

    public AssinaturaModel save(Long aplicativoCodigo, Long clienteCodigo) {
        ClienteModel cliente = clienteService.findByCodigo(clienteCodigo);
        AplicativoModel aplicativo = aplicativoService.findByCodigo(aplicativoCodigo);
        AssinaturaModel assinatura = new AssinaturaModel(aplicativo, cliente);

        // Salvar no banco
        AssinaturaModel savedAssinatura = assinaturaRepository.save(assinatura);

        // Atualizar o cache
        atualizaCache(savedAssinatura);

        // Notificar o RabbitMQ
        rabbitTemplate.convertAndSend(assinaturaExchange, assinaturaRoutingKey, savedAssinatura);

        return savedAssinatura;
    }

    public Boolean verificaValidade(Long codigoAssinatura) {
        // Tentar buscar no AssCache
        try {
            Boolean validade = restTemplate.getForObject(assCacheUrl + "/assinaturas/{codigo}/validade", Boolean.class, codigoAssinatura);
            if (validade != null) return validade;
        } catch (Exception e) {
            // Logar erro e continuar com busca no banco
            System.err.println("Erro ao consultar o AssCache: " + e.getMessage());
        }

        // Consultar no banco de dados como fallback
        AssinaturaModel assinatura = assinaturaRepository.findByCodigo(codigoAssinatura);
        return LocalDateTime.now().isAfter(assinatura.getInicioVigencia()) && LocalDateTime.now().isBefore(assinatura.getFimVigencia());
    }

    public List<AssinaturaModel> buscaAssinaturasPorCliente(Long codigoCliente) {
        return assinaturaRepository.findByCodigoCliente(codigoCliente);
    }

    public List<AssinaturaModel> buscaAssinaturasPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.findByCodigoAplicativo(codigoAplicativo);
    }

    public AssinaturaModel findByCodigo(Long codigo) {
        return assinaturaRepository.findByCodigo(codigo);
    }

    public void renovaAssinatura(Long codigo) {
        AssinaturaModel assinaturaModel = assinaturaRepository.findByCodigo(codigo);

        assinaturaModel.setInicioVigencia(LocalDateTime.now());
        if (LocalDateTime.now().isBefore(assinaturaModel.getFimVigencia())) {
            assinaturaModel.setFimVigencia(assinaturaModel.getFimVigencia().plusDays(30));
        } else {
            assinaturaModel.setFimVigencia(LocalDateTime.now().plusDays(30));
        }

        // Salvar alterações
        AssinaturaModel updatedAssinatura = assinaturaRepository.save(assinaturaModel);

        // Atualizar o cache
        atualizaCache(updatedAssinatura);

        // Notificar o RabbitMQ
        rabbitTemplate.convertAndSend(assinaturaExchange, assinaturaRoutingKey, updatedAssinatura);
    }

    private void atualizaCache(AssinaturaModel assinaturaModel) {
        try {
            AssinaturaCacheModel cacheModel = new AssinaturaCacheModel();
            cacheModel.setAssinaturaId(assinaturaModel.getCodigo());
            cacheModel.setClienteNome(assinaturaModel.getCliente().getNome());
            cacheModel.setAplicativoNome(assinaturaModel.getAplicativo().getNome());
            cacheModel.setStatus("ATIVA"); // Ou outra lógica de status
            cacheModel.setValidade(assinaturaModel.getFimVigencia().toString());

            // Enviar para o AssCache
            restTemplate.postForObject(assCacheUrl + "/api/asscache", cacheModel, Void.class);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o AssCache: " + e.getMessage());
        }
    }
}
