package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.repository.IAssinaturaRepository;
import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class AssinaturaJPARespository implements IAssinaturaRepository {
    private IAssinaturaJPARepository assinaturaRepository;

    public AssinaturaJPARespository(IAssinaturaJPARepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    @Override
    public AssinaturaModel save(AssinaturaModel assinatura) {
        Assinatura assin = Assinatura.fromAssinaturaModel(assinatura);
        Assinatura assinaturaInserida = assinaturaRepository.save(assin);
        return Assinatura.toAssinaturaModel(assinaturaInserida);
    }

    @Override
    public AssinaturaModel findByCodigo(Long codigo) {
        Assinatura assin = assinaturaRepository.findByCodigo(codigo);
        return Assinatura.toAssinaturaModel(assin);
    }

    @Override
    public List<AssinaturaModel> findByCodigoCliente(Long codigoCliente) {
        List<Assinatura> assinaturas = assinaturaRepository.findByClienteCodigo(codigoCliente);
        return assinaturas.stream()
                .map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public List<AssinaturaModel> findByCodigoAplicativo(Long codigoAplicativo) {
        List<Assinatura> assinaturas = assinaturaRepository.findByAplicativoCodigo(codigoAplicativo);
        return assinaturas.stream()
                .map(Assinatura::toAssinaturaModel).toList();
    }
}
