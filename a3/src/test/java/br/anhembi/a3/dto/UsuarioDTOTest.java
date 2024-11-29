package br.anhembi.a3.dto;

import org.junit.jupiter.api.Test;

import br.anhembi.a3.model.Usuario;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioDTOTest {

    @Test
    void criarUsuarioDTO_semArgumentos_usuarioDTOCriadoSucesso(){
        UsuarioDTO usuarioDto = new UsuarioDTO();

        assertThat(usuarioDto).isNotNull();
    }

    @Test
    void criarUsuarioDTO_todosArgumentosValidos_usuarioDTOCriadoSucesso(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto).isNotNull();
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_idCorreto(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getId()).isEqualTo(id);
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_nomeCorreto(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getNome()).isEqualTo(nome);
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_cpfCorreto(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getCpf()).isEqualTo(cpf);
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_telefoneCorreto(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getTelefone()).isEqualTo(telefone);
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_emailCorreto(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getEmail()).isEqualTo(email);
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_senhaCorreta(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getSenha()).isEqualTo(senha);
    }

    @Test
    void criarUsuarioDTO_argumentosValidos_scoreCorreto(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);

        assertThat(usuarioDto.getScore()).isEqualTo(score);
    }

    @Test
    void criarUsuarioDTO_usuarioValido_usuarioDTOCriadoSucesso(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);
        UsuarioDTO usuarioDto = new UsuarioDTO(usuario);

        assertThat(usuarioDto).isNotNull();
    }

    @Test
    void transformarUsuarioDTOEmUsuario_argumentosValidos_usuarioCriadoSucesso(){
        int id = 1;
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";
        int score = 1;

        UsuarioDTO usuarioDto = new UsuarioDTO(id, nome, cpf, telefone, email, senha, score);
        Usuario usuario = usuarioDto.toUsuario();

        assertThat(usuario).isNotNull();
    }
}
