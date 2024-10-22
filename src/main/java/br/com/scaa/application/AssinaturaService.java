package br.com.scaa.application;

import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import br.com.scaa.infraestructure.persistence.entities.Cliente;
import br.com.scaa.infraestructure.persistence.repository.IAssinaturaJPARepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssinaturaService {

    private final IAssinaturaJPARepository assinaturaRepository;
    private final ClienteService clienteService;
    private final AplicativoService aplicativoService;
    public AssinaturaService(IAssinaturaJPARepository assinaturaRepository, AplicativoService aplicativoService, ClienteService clienteService) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoService = aplicativoService;
        this.clienteService =clienteService;
    }
    public Assinatura save(Long aplicativoCodigo, Long clienteCodigo) {
        Cliente cliente = clienteService.findByCodigo(clienteCodigo);
        Aplicativo aplicativo = aplicativoService.findByCodigo(aplicativoCodigo);
        Assinatura assinatura = new Assinatura(aplicativo, cliente);
        return assinaturaRepository.save(assinatura);
    }

    public Boolean verificaValidade(Long codigoAssinatura) {
        Assinatura assinatura = assinaturaRepository.getReferenceById(codigoAssinatura);
        return LocalDateTime.now().isAfter(assinatura.getInicioVigencia()) && LocalDateTime.now().isBefore(assinatura.getFimVigencia());
    }

    public List<Assinatura> buscaAssinaturasPorCliente(Long codigoCliente) {
        return assinaturaRepository.findByClienteCodigo(codigoCliente);
    }

    public List<Assinatura> buscaAssinaturasPorAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.findByAplicativoCodigo(codigoAplicativo);
    }
}
