package br.com.scaa.infraestructure.persistence.entities;

import br.com.scaa.domain.PagamentoModel;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    @ManyToOne
    private Assinatura assinatura;

    public static Pagamento fromPagamentoModel(br.com.scaa.domain.PagamentoModel pagamento) {
        Pagamento pag = new Pagamento();
        pag.setCodigo(pagamento.getCodigo());
        pag.setValorPago(pagamento.getValorPago());


        Date datePagamento = new Date(pagamento.getDataPagamento());
        pag.setDataPagamento(datePagamento);

        pag.setPromocao(pagamento.getPromocao());
        return pag;
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {
        PagamentoModel pag = new PagamentoModel();
        pag.setCodigo(pagamento.getCodigo());
        pag.setValorPago(pagamento.getValorPago());
        pag.setDataPagamento(pagamento.getDataPagamento().toString());
        pag.setPromocao(pagamento.getPromocao());
        return pag;
    }
}
