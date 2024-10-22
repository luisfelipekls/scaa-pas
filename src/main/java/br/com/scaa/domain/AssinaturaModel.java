package br.com.scaa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssinaturaModel {
    private Long codigo;
    private Date inicioVigencia;
    private Date fimVigencia;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;
    private PagamentoModel pagamento;

    public AssinaturaModel(Date inicioVigencia, Date fimVigencia, AplicativoModel aplicativo, ClienteModel cliente, PagamentoModel pagamento) {
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }
}
