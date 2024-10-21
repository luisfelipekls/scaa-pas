package br.com.scaa.infraestructure.persistence.entities;

import jakarta.persistence.Entity;
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
    private int id;
    private Long codigo;
    private String nome;
    private String email;
}
