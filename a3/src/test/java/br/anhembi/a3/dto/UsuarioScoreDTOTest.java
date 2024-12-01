package br.anhembi.a3.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UsuarioScoreDTOTest {

    @Test
    void criarUsuario_semArgumentos_usuarioCriadoSucesso(){
        UsuarioScoreDTO usuarioScore = new UsuarioScoreDTO();
        
        assertThat(usuarioScore).isNotNull();
    }

    @Test
    void setarCpf_cpfValido_scoreCorreto(){
        UsuarioScoreDTO usuarioScore = new UsuarioScoreDTO();
        int score = 2;

        usuarioScore.setScore(score);

        assertEquals(score, usuarioScore.getScore());
    }
}
