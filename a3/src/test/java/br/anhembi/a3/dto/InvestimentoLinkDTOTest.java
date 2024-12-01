package br.anhembi.a3.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class InvestimentoLinkDTOTest {

    @Test
    void criarInvestimentoLinkDTO_semArgumentos_InvestimentoLinkDTOCriadoSucesso(){
        InvestimentoLinkDTO link = new InvestimentoLinkDTO();

        assertThat(link).isNotNull();
    }

    @Test
    void setarInvestimentosIds_listaValida_investimentosIdsSetados(){
        InvestimentoLinkDTO link = new InvestimentoLinkDTO();
        List<Integer> investimentosIds = new ArrayList<>();
        int id_1 = 1;
        
        investimentosIds.add(id_1);
        link.setInvestimentoIds(investimentosIds);

        assertEquals(investimentosIds, link.getInvestimentoIds());
    }
}
