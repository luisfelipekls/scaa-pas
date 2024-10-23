package br.com.scaa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssinaturaModel {
    private Long codigo;
    private LocalDateTime inicioVigencia;
    private LocalDateTime fimVigencia;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;

    public AssinaturaModel(LocalDateTime inicioVigencia, LocalDateTime fimVigencia, AplicativoModel aplicativo, ClienteModel cliente) {
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
    }

    public AssinaturaModel(AplicativoModel aplicativo, ClienteModel cliente) {
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = LocalDateTime.now();
        this.fimVigencia = LocalDateTime.now().plusDays(7);
    }
}
