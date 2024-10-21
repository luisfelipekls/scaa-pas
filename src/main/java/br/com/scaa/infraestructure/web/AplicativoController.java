package br.com.scaa.infraestructure.web;

import br.com.scaa.application.AplicativoService;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {
    private final AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    @GetMapping
    public ResponseEntity<List<Aplicativo>> listAll(){
        List<Aplicativo> aplicativos = aplicativoService.findAll();
        return ResponseEntity.ok(aplicativos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aplicativo> findById(@PathVariable Long id){
        return ResponseEntity.ok(aplicativoService.findById(id));
    }
}
