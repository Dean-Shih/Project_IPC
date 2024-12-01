package br.anhembi.a3.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.anhembi.a3.model.Investimento;

public class InvestimentoDTOTest {

    private InvestimentoDTO investimentoDTO;

    @BeforeEach
    void setup(){
        Investimento investimento = new Investimento();
        investimentoDTO = new InvestimentoDTO(investimento);
    }

    @Test
    void criarInvestimentoDTO_investimentoValido_InvestimentoDTOCriadoSucesso(){
        Investimento investimento = new Investimento();
        InvestimentoDTO investimentoDTO = new InvestimentoDTO(investimento);

        assertThat(investimentoDTO).isNotNull();
    }

    @Test
    void setarId_investimentos_valorValido_id_investimentosSetadoSucesso(){
        int id = 1;
        investimentoDTO.setId_investimentos(id);

        assertEquals(id, investimentoDTO.getId_investimentos());
    }

    @Test
    void setarNome_valorValido_nomeSetadoSucesso(){
        String nome = "Opções";
        investimentoDTO.setNome(nome);

        assertEquals(nome, investimentoDTO.getNome());
    }

    @Test
    void setarValor_valorValido_id_valorSetadoSucesso(){
        int valor = 83;
        investimentoDTO.setValor(valor);

        assertEquals(valor, investimentoDTO.getValor());
    }

}
