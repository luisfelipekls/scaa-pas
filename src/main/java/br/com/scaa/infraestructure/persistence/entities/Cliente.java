package br.com.scaa.infraestructure.persistence.entities;

import br.com.scaa.domain.ClienteModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String email;

    public static Cliente fromClienteModel(ClienteModel cliente) {
        return new Cliente(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }

    public static ClienteModel toClienteModel(Cliente cliente) {
        return new ClienteModel(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}
