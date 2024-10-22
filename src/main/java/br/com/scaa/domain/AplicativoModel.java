package br.com.scaa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AplicativoModel {
    private Long codigo;
    private String nome;
    private double custoMensal;

    public AplicativoModel(String nome, double custoMensal) {
        this.nome = nome;
        this.custoMensal = custoMensal;
    }
}
