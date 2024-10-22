package br.com.scaa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {
    private Long codigo;
    private String nome;
    private String email;

    public ClienteModel(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
