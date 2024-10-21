package br.com.scaa.infraestructure.persistence.entities;

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
public class Assinatura {
    @Id
    private int id;
    private Long codigo;
    private Date inicioVigencia;
    private Date fimVigencia;
    @ManyToOne
    private Aplicativo aplicativo;
    @ManyToOne
    private Cliente cliente;
}
