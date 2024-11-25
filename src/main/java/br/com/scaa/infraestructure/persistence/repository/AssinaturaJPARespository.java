package br.com.scaa.infrastructure.persistence.repository;

import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.domain.repository.IAssinaturaRepository;
import br.com.scaa.infrastructure.messaging.RabbitMQPublisher;
import br.com.scaa.infrastructure.persistence.entities.Assinatura;
import org.springframework.stereotype.Repository;

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

        return savedEntity.toAssinaturaModel();
    }

    @Override
    public AssinaturaModel findByCodigo(Long codigo) {
        Optional<Assinatura> assinaturaOptional = jpaRepository.findById(codigo);
        return assinaturaOptional.map(Assinatura::toAssinaturaModel).orElse(null);
    }

    @Override
    public List<AssinaturaModel> findByCodigoCliente(Long codigoCliente) {
        return jpaRepository.findByCodigoCliente(codigoCliente)
                .stream()
                .map(Assinatura::toAssinaturaModel)
                .toList();
    }

    @Override
    public List<AssinaturaModel> findByCodigoAplicativo(Long codigoAplicativo) {
        return jpaRepository.findByCodigoAplicativo(codigoAplicativo)
                .stream()
                .map(Assinatura::toAssinaturaModel)
                .toList();
    }
}
