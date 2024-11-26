package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.repository.IAssinaturaRepository;
import br.com.scaa.infraestructure.persistence.RabbitMQPublisher;
import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AssinaturaJPARepository implements IAssinaturaRepository {

    private final IAssinaturaJPARepository jpaRepository;
    private final RabbitMQPublisher rabbitMQPublisher;

    public AssinaturaJPARepository(IAssinaturaJPARepository jpaRepository, RabbitMQPublisher rabbitMQPublisher) {
        this.jpaRepository = jpaRepository;
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    @Override
    public AssinaturaModel save(AssinaturaModel assinaturaModel) {
        Assinatura assinatura = Assinatura.fromAssinaturaModel(assinaturaModel);
        Assinatura savedEntity = jpaRepository.save(assinatura);

        // Publicar evento após salvar no banco
        rabbitMQPublisher.publishEvent(
            String.format("Assinatura %d foi atualizada.", savedEntity.getCodigo())
        );

        return Assinatura.toAssinaturaModel(savedEntity);
    }

    @Override
    public AssinaturaModel findByCodigo(Long codigo) {
        Optional<Assinatura> assinaturaOptional = jpaRepository.findById(codigo);
        return assinaturaOptional.map(Assinatura::toAssinaturaModel).orElse(null);
    }

    @Override
    public List<AssinaturaModel> findByCodigoCliente(Long codigoCliente) {
        return jpaRepository.findByClienteCodigo(codigoCliente)
                .stream()
                .map(Assinatura::toAssinaturaModel)
                .toList();
    }

    @Override
    public List<AssinaturaModel> findByCodigoAplicativo(Long codigoAplicativo) {
        return jpaRepository.findByAplicativoCodigo(codigoAplicativo)
                .stream()
                .map(Assinatura::toAssinaturaModel)
                .toList();
    }
}
