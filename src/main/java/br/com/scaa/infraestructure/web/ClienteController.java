package br.com.scaa.infraestructure.web;

import br.com.scaa.application.ClienteService;
import br.com.scaa.domain.ClienteModel;
import br.com.scaa.infraestructure.persistence.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> findByCodigo(@PathVariable Long codigo){
        return ResponseEntity.ok(clienteService.findByCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteModel cliente){
        Cliente cli = Cliente.fromClienteModel(cliente);
        return ResponseEntity.ok(clienteService.save(cli));
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.update(cliente));
    }
}
