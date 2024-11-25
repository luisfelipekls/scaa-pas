package br.com.scaa.infraestructure.persistence.entities;

import br.com.scaa.domain.PagamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime dataPagamento;
    private String promocao;
    @ManyToOne
    private Assinatura assinatura;

    public static Pagamento fromPagamentoModel(PagamentoModel pagamento) {
        Pagamento pag = new Pagamento();
        pag.setCodigo(pagamento.getCodigo());
        pag.setValorPago(pagamento.getValorPago());
        pag.setDataPagamento(pagamento.getDataPagamento());
        pag.setPromocao(pagamento.getPromocao());
        pag.setAssinatura(Assinatura.fromAssinaturaModelToCreate(pagamento.getAssinatura()));
        return pag;
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {
        PagamentoModel pag = new PagamentoModel();
        pag.setCodigo(pagamento.getCodigo());
        pag.setValorPago(pagamento.getValorPago());
        pag.setDataPagamento(pagamento.getDataPagamento());
        pag.setPromocao(pagamento.getPromocao());
        return pag;
    }
}