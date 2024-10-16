package br.com.scaa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Pagamento {
    @Id
    private int id;
    private Long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    @ManyToOne
    private Assinatura assinatura;
}
