package br.com.scaa.domain;

import br.com.scaa.infraestructure.persistence.entities.Assinatura;
import br.com.scaa.infraestructure.utils.CommonUtils;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoModel {

    private long codigo;
    private Double valorPago;
    private LocalDateTime dataPagamento;
    private String promocao;
    private AssinaturaModel assinatura;
    private long assinaturaCodigo;

    public void validate() {
        if (valorPago == null || valorPago <= 0) {
            throw new IllegalArgumentException("Valor inválido: Valor a ser pago não pode ser nulo e deve ser maior que zero");
        }
        if (dataPagamento == null) {
            throw new IllegalArgumentException("Valor inválido: Data de pagamento não pode ser nula");
        }

        LocalDateTime dataAtual = LocalDateTime.now();

        if (dataPagamento.isAfter(dataAtual)) {
            throw new IllegalArgumentException("Valor inválido: Data de pagamento não pode ser maior que a data atual");
        }

        if(!CommonUtils.promocoes.contains(promocao)){
            throw new IllegalArgumentException("Valor inválido: Promoção inválida");
        }
    }
}