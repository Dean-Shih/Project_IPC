package br.anhembi.a3.dto;

import br.anhembi.a3.model.Investimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestimentoDTO {

    private int Id_investimentos;
    private String Nome;
    private int Valor;

    public InvestimentoDTO(Investimento inv) {
        Id_investimentos = inv.getId_investimentos();
        Nome = inv.getNome();
        Valor =  inv.getValor();
    }
}
