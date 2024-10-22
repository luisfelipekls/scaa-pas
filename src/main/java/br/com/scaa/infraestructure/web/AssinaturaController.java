package br.com.scaa.infraestructure.web;

import br.com.scaa.application.AplicativoService;
import br.com.scaa.application.AssinaturaService;
import br.com.scaa.domain.AplicativoModel;
import br.com.scaa.domain.AssinaturaModel;
import br.com.scaa.infraestructure.persistence.entities.Aplicativo;
import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {
    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @PostMapping
    public ResponseEntity<AssinaturaModel> cadastra(@RequestParam Long codigoAplicativo, @RequestParam Long codigoCliente){
        return ResponseEntity.ok(assinaturaService.save(codigoAplicativo, codigoCliente));
    }

    @GetMapping("/validade")
    public ResponseEntity<Boolean> verificaValidade(@RequestParam Long codigoAssinatura){
        return ResponseEntity.ok(assinaturaService.verificaValidade(codigoAssinatura));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<AssinaturaModel>> listaAssinaturasPorCliente(@RequestParam Long codigoCliente){
        return ResponseEntity.ok(assinaturaService.buscaAssinaturasPorCliente(codigoCliente));
    }

    @GetMapping("/aplicativo")
    public ResponseEntity<List<AssinaturaModel>> listaAssinaturasPorAplicativo(@RequestParam Long codigoAplicativo){
        return ResponseEntity.ok(assinaturaService.buscaAssinaturasPorAplicativo(codigoAplicativo));
    }
}
