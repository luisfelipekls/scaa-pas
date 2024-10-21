package br.com.scaa.infraestructure.persistence.entities;

import br.com.scaa.domain.AplicativoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private double custoMensal;

    public static Aplicativo fromAplicativoModel(AplicativoModel appModel) {
        return new Aplicativo(appModel.getCodigo(), appModel.getNome(), appModel.getCustoMensal());
    }

    public static AplicativoModel toAplicativoModel(Aplicativo app) {
        return new AplicativoModel(app.getCodigo(), app.getNome(), app.getCustoMensal());
    }
}
