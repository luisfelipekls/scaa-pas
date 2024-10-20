package br.com.scaa.application;

import br.com.scaa.domain.Aplicativo;
import br.com.scaa.domain.interfaces.IAplicativoRepository;

import java.util.List;

public class AplicativoService {

    private final IAplicativoRepository aplicativoRepository;
    public AplicativoService(IAplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<Aplicativo> findAll(){
        return aplicativoRepository.findAll();
    }

    public Aplicativo findById(Long id){
        return aplicativoRepository.findById(id).get();
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
}
