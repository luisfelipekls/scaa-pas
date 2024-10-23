package br.com.scaa.infraestructure.web;

import br.com.scaa.application.AplicativoService;
import br.com.scaa.domain.AplicativoModel;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {
    private final AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    @GetMapping
    public ResponseEntity<List<AplicativoModel>> listAll(){
        List<AplicativoModel> aplicativos = aplicativoService.findAll();
        return ResponseEntity.ok(aplicativos);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<AplicativoModel> findByCodigo(@PathVariable Long codigo){
        return ResponseEntity.ok(aplicativoService.findByCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<AplicativoModel> save(@RequestBody AplicativoModel aplicativo){
        Aplicativo app = Aplicativo.fromAplicativoModel(aplicativo);
        return ResponseEntity.ok(aplicativoService.save(app));
    }

    @PutMapping
    public ResponseEntity<AplicativoModel> update(@RequestBody Aplicativo aplicativo){
        return ResponseEntity.ok(aplicativoService.update(aplicativo));
    }
}
