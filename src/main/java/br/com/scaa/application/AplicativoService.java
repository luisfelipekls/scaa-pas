package br.com.scaa.application;

import br.com.scaa.domain.AplicativoModel;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import br.com.scaa.infraestructure.persistence.repository.IAplicativoJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {

    private final IAplicativoJPARepository aplicativoRepository;
    public AplicativoService(IAplicativoJPARepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<AplicativoModel> findAll(){
        return aplicativoRepository.findAll().stream().map(
                Aplicativo::toAplicativoModel
        ).toList();
    }

    public AplicativoModel findByCodigo(Long codigo){
        return Aplicativo.toAplicativoModel(aplicativoRepository.findByCodigo(codigo));
    }

    public AplicativoModel save(Aplicativo aplicativo){
        return Aplicativo.toAplicativoModel(aplicativoRepository.save(aplicativo));
    }

    public AplicativoModel update(Aplicativo aplicativo){
        return Aplicativo.toAplicativoModel(aplicativoRepository.save(aplicativo));
    }

    public AplicativoModel updateCustoMensal(Long id, double novoCustoMensal){
        Aplicativo aplicativo = aplicativoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aplicativo não encontrado com o ID: " + id));
        aplicativo.setCustoMensal(novoCustoMensal);
        return Aplicativo.toAplicativoModel(aplicativoRepository.save(aplicativo));
    }
}
