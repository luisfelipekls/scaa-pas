package br.com.scaa.application;

import br.com.scaa.domain.AplicativoModel;
import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.ClienteModel;
import br.com.scaa.domain.repository.IAssinaturaRepository;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import br.com.scaa.infraestructure.persistence.entities.Cliente;
import br.com.scaa.infraestructure.persistence.repository.AssinaturaJPARespository;
import br.com.scaa.infraestructure.persistence.repository.IAssinaturaJPARepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssinaturaService {

    private final IAssinaturaRepository assinaturaRepository;
    private final ClienteService clienteService;
    private final AplicativoService aplicativoService;
    public AssinaturaService(IAssinaturaRepository assinaturaRepository, AplicativoService aplicativoService, ClienteService clienteService) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoService = aplicativoService;
        this.clienteService =clienteService;
    }
    public AssinaturaModel save(Long aplicativoCodigo, Long clienteCodigo) {
        ClienteModel cliente = clienteService.findByCodigo(clienteCodigo);
        AplicativoModel aplicativo = aplicativoService.findByCodigo(aplicativoCodigo);
        AssinaturaModel assinatura = new AssinaturaModel(aplicativo, cliente);
        return assinaturaRepository.save(assinatura);
    }

    public Boolean verificaValidade(Long codigoAssinatura) {
        AssinaturaModel assinatura = assinaturaRepository.findByCodigo(codigoAssinatura);
        return LocalDateTime.now().isAfter(assinatura.getInicioVigencia()) && LocalDateTime.now().isBefore(assinatura.getFimVigencia());
    }

    public List<AssinaturaModel> buscaAssinaturasPorCliente(Long codigoCliente) {
        return assinaturaRepository.findByCodigoCliente(codigoCliente);
    }

    public List<AssinaturaModel> buscaAssinaturasPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.findByCodigoAplicativo(codigoAplicativo);
    }
}
