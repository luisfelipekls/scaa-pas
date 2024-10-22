package br.com.scaa.infraestructure.persistence.entities;

import br.com.scaa.domain.AssinaturaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDateTime inicioVigencia;
    private LocalDateTime fimVigencia;
    @ManyToOne
    private Aplicativo aplicativo;
    @ManyToOne
    private Cliente cliente;

    public Assinatura(Aplicativo aplicativo, Cliente cliente) {
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = LocalDateTime.now();
        this.fimVigencia = LocalDateTime.now().plusDays(7);
    }
}
