package br.com.scaa.infraestructure.persistence.repository;

import br.com.scaa.domain.AplicativoModel;
import br.com.scaa.domain.repository.IAplicativoRepository;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import java.util.List;

public class AplicativoJPARepository implements IAplicativoRepository {
    private IAplicativoJPARepository aplicativoRepository;

    @Override
    public List<AplicativoModel> findAll() {
        List<Aplicativo> aplicativo = aplicativoRepository.findAll();
        return aplicativo.stream()
                .map(app -> Aplicativo.toAplicativoModel(app)).toList();
    }

    @Override
    public AplicativoModel findById(Long id) {
        Aplicativo aplicativo = aplicativoRepository.findById(id).orElse(null);
        return Aplicativo.toAplicativoModel(aplicativo);
    }

    @Override
    public AplicativoModel save(AplicativoModel aplicativo) {
        Aplicativo app = Aplicativo.fromAplicativoModel(aplicativo);
        Aplicativo aplicativoInserido = aplicativoRepository.save(app);
        return Aplicativo.toAplicativoModel(aplicativoInserido);
    }

    @Override
    public AplicativoModel update(AplicativoModel aplicativo) {
        Aplicativo app = Aplicativo.fromAplicativoModel(aplicativo);
        Aplicativo aplicativoAtualizado = aplicativoRepository.save(app);
        return Aplicativo.toAplicativoModel(aplicativoAtualizado);
    }

    @Override
    public void delete(AplicativoModel aplicativo) {
        Aplicativo app = Aplicativo.fromAplicativoModel(aplicativo);
        aplicativoRepository.delete(app);
    }
}
