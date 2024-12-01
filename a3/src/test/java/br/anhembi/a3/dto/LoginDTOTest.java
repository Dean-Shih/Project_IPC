package br.anhembi.a3.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LoginDTOTest {

    @Test
    void criarLoginDTO_semArgumentos_loginDTOCriadoSucesso(){
        LoginDTO login = new LoginDTO();

        assertThat(login).isNotNull();
    }

    @Test
    void criarLoginDTO_criadoSucesso_liberadoVemFalso(){
        LoginDTO login = new LoginDTO();

        assertEquals(false, login.isLiberado());
    }

    @Test
    void setarCpf_cpfValido_cpfSetadoSucesso(){
        LoginDTO login = new LoginDTO();
        String cpf = "12345678901";

        login.setCpf(cpf);

        assertEquals(cpf, login.getCpf());
    }

    @Test
    void setarSenha_senhaValida_senhaSetadaSucesso(){
        LoginDTO login = new LoginDTO();
        String senha = "00000";

        login.setSenha(senha);

        assertEquals(senha, login.getSenha());
    }

    @Test
    void setarLiberado_booleanValido_liberadoSetadoSucesso(){
        LoginDTO login = new LoginDTO();
        boolean liberado = true;

        login.setLiberado(liberado);

        assertEquals(liberado, login.isLiberado());
    }

}
