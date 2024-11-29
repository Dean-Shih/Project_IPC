package br.anhembi.a3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setup(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        usuario = new Usuario(nome, cpf, telefone, email, senha);
    }

    @Test
    void criarUsuario_semArgumentos_usuarioCriadoSucesso(){
        Usuario usuario = new Usuario();

        assertThat(usuario).isNotNull();
    }

    @Test
    void criarUsuario_argumentosValidos_usuarioCriadoSucesso(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        assertThat(usuario).isNotNull();
    }

    @Test
    void criarUsuario_argumentosValidos_nomeCorreto(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        assertThat(usuario.getNome()).isEqualTo(nome);
    }

    @Test
    void criarUsuario_argumentosValidos_cpfCorreto(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        assertThat(usuario.getCpf()).isEqualTo(cpf);
    }

    @Test
    void criarUsuario_argumentosValidos_telefoneCorreto(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        assertThat(usuario.getTelefone()).isEqualTo(telefone);
    }

    @Test
    void criarUsuario_argumentosValidos_emailCorreto(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        assertThat(usuario.getEmail()).isEqualTo(email);
    }

    @Test
    void criarUsuario_argumentosValidos_senhaCorreta(){
        String nome = "Thiago";
        String cpf = "12345678901";
        String telefone = "11999999999";
        String email = "email@email.com";
        String senha = "11111";

        Usuario usuario = new Usuario(nome, cpf, telefone, email, senha);

        assertThat(usuario.getSenha()).isEqualTo(senha);
    }

    @Test
    void criarUsuario_argumentosValidos_scoreSeraZero(){
        assertThat(usuario.getScore()).isEqualTo(0);
    }

    @Test
    void criarUsuario_argumentosValidos_idUsuarioSeraZero(){
        assertThat(usuario.getId_Usuario()).isEqualTo(0);
    }

    @Test
    void criarUsuario_argumentosValidos_investimentosSeraVazio(){
        assertNull(usuario.getInvestimentos());
    }

    @Test
    void criarListaInvestimentos_investimentoValido_investimentoAdicionado(){
        usuario.setInvestimentos(new ArrayList<>());
        Investimento investimento = new Investimento();
        
        ArrayList<Investimento> investimento_array = new ArrayList<>();
        investimento_array.add(investimento);
        usuario.addInvestimento(investimento_array);

        assertThat(usuario.getInvestimentos()).isNotEmpty();
    }
}
