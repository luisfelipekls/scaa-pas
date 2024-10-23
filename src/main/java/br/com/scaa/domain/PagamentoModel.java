package br.com.scaa.domain;

import br.com.scaa.infraestructure.utils.CommonUtils;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoModel {

    private long codigo;
    private Double valorPago;
    private String dataPagamento;
    private String promocao;
    private long assinaturaId;

    public void validate() {
        if (valorPago == null || valorPago <= 0) {
            throw new IllegalArgumentException("Valor inválido: Valor a ser pago não pode ser nulo e deve ser maior que zero");
        }
        if (dataPagamento == null) {
            throw new IllegalArgumentException("Valor inválido: Data de pagamento não pode ser nula");
        }

        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataPagamento = LocalDateTime.parse(this.dataPagamento);

        if (dataPagamento.isAfter(dataAtual)) {
            throw new IllegalArgumentException("Valor inválido: Data de pagamento não pode ser maior que a data atual");
        }

        if(!CommonUtils.promocoes.contains(promocao)){
            throw new IllegalArgumentException("Valor inválido: Promoção inválida");
        }
    }

}
