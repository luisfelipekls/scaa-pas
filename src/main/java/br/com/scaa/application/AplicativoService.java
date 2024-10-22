package br.com.scaa.application;

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

    public List<Aplicativo> findAll(){
        return aplicativoRepository.findAll();
    }

    public Aplicativo findByCodigo(Long codigo){
        return aplicativoRepository.findByCodigo(codigo);
    }

    public Aplicativo save(Aplicativo aplicativo){
        return aplicativoRepository.save(aplicativo);
    }

    public Aplicativo update(Aplicativo aplicativo){
        return aplicativoRepository.save(aplicativo);
    }

    public void delete(Aplicativo aplicativo){
        aplicativoRepository.delete(aplicativo);
    }

    public Aplicativo updateCustoMensal(Long id, double novoCustoMensal){
        Aplicativo aplicativo = aplicativoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aplicativo não encontrado com o ID: " + id));
        aplicativo.setCustoMensal(novoCustoMensal);
        return aplicativoRepository.save(aplicativo);
    }
}
