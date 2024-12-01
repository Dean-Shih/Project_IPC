package br.anhembi.a3.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InvestimentoTest {

    @Test
    void criarInvestimento_semArgumentos_investimentoCriadoSucesso(){
        Investimento investimento = new Investimento();

        assertThat(investimento).isNotNull();
    }
}
