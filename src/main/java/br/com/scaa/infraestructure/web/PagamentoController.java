package br.com.scaa.infraestructure.web;

import br.com.scaa.application.PagamentoService;
import br.com.scaa.domain.PagamentoModel;
import br.com.scaa.domain.repository.IPagamentoRepository;
import br.com.scaa.infraestructure.persistence.entities.Pagamento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/registrarPagamento")
    public ResponseEntity<Object> registrarPagamento(@RequestBody PagamentoModel pagamentoBody){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.save(pagamentoBody));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
