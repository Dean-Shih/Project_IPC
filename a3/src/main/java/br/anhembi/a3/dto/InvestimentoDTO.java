package br.anhembi.a3.dto;

import br.anhembi.a3.model.Investimento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestimentoDTO {

    private int id_investimentos;
    private String nome;
    private int valor;

    public InvestimentoDTO(Investimento inv) {
        id_investimentos = inv.getId_investimentos();
        nome = inv.getNome();
        valor =  inv.getValor();
    }
}
