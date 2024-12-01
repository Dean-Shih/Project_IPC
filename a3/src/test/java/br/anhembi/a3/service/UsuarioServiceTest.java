package br.anhembi.a3.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.anhembi.a3.dto.LoginDTO;
import br.anhembi.a3.model.Investimento;
import br.anhembi.a3.model.Usuario;
import br.anhembi.a3.repository.InvestimentoRepo;
import br.anhembi.a3.repository.UsuarioRepo;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepo usuarioRepo;

    @Mock
    private InvestimentoRepo investimentoRepo;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarUsuario_idDiferenteZero_retornarOptionalVazio() {
        Usuario usuario = new Usuario();

        usuario.setId_Usuario(1);
        Optional<Usuario> resultado = usuarioService.create(usuario);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void criarUsuario_idZero_usuarioCriado() {
        Usuario usuario = new Usuario();

        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        Optional<Usuario> resultado = usuarioService.create(usuario);

        assertTrue(resultado.isPresent());
    }

    @Test
    void procuarUsuarioPorId_idInvalido_retornarOptionalVazio() {
        int id = 1;

        when(usuarioRepo.findById(id)).thenReturn(Optional.empty());

        Optional<Usuario> resultado = usuarioService.findById(id);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void procuarUsuarioPorId_idValido_usuarioEncontrado() {
        int id = 1;
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(id);

        when(usuarioRepo.findById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.findById(id);

        assertTrue(resultado.isPresent());
    }

    @Test
    void procurarTodosUsuarios_usuariosInexistentes_retornarListaVazia() {
        when(usuarioRepo.findAll()).thenReturn(List.of());

        List<Usuario> usuarios = usuarioService.findAll();

        assertTrue(usuarios.isEmpty());
    }

    @Test
    void procurarTodosUsuarios_usuariosExistentes_retornarListaDeUsuarios() {
        Usuario usuario = new Usuario();
        ArrayList<Usuario> arrayList = new ArrayList<>();
        arrayList.add(usuario);

        when(usuarioRepo.findAll()).thenReturn(arrayList);

        List<Usuario> usuarios = usuarioService.findAll();

        assertFalse(usuarios.isEmpty());
    }

    @Test
    void procurarUsuarioPorCpf_cpfInexistente_retornarOptionalVazio() {
        String cpf = "111";

        when(usuarioRepo.findByCpf(cpf)).thenReturn(Optional.empty());

        Optional<Usuario> resultado = usuarioService.findByCpf(cpf);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void procurarUsuarioPorCpf_cpfExistente_retornarUsuario() {
        String cpf = "111";
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);

        when(usuarioRepo.findByCpf(cpf)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.findByCpf(cpf);

        assertTrue(resultado.isPresent());
    }

    @Test
    void deletarUsuario_idMenorigualZero_usuarioNaoDeletado() {
        int id = 0;

        boolean result = usuarioService.delete(id);

        assertFalse(result);
    }

    @Test
    void deletarUsuario_usuarioInexistente_usuarioNaoDeletado() {
        int id = 1;

        when(usuarioRepo.findById(id)).thenReturn(Optional.empty());

        boolean result = usuarioService.delete(id);

        assertFalse(result);
    }

    @Test
    void deletarUsuario_usuarioExistente_usuarioDeletado() {
        int id = 1;
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(id);

        when(usuarioRepo.findById(id)).thenReturn(Optional.of(usuario));

        boolean result = usuarioService.delete(id);

        assertTrue(result);
    }

    @Test
    void atualizarUsuario_idMenorIgualZero_usuarioNaoAtualizado() {
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(0);

        Optional<Usuario> result = usuarioService.update(usuario);

        assertTrue(result.isEmpty());
    }

    @Test
    void atualizarUsuario_idValidoInexistente_usuarioNaoAtualizado() {
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(1);

        when(usuarioRepo.findById(usuario.getId_Usuario())).thenReturn(Optional.empty());

        Optional<Usuario> result = usuarioService.update(usuario);

        assertTrue(result.isEmpty());
    }

    @Test
    void atualizarUsuario_idValidoExistente_usuarioAtualizado() {
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(1);
        usuario.setNome("Nome Atualizado");

        when(usuarioRepo.findById(usuario.getId_Usuario())).thenReturn(Optional.of(new Usuario()));
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        Optional<Usuario> result = usuarioService.update(usuario);

        assertTrue(result.isPresent());
        assertEquals(usuario, result.get());
    }

    @Test
    void atualizarInvestimentos_usuarioNaoEncontrado_investimentosNaoAtualizados() {
        int usuarioId = 1;
        List<Integer> investimentoIds = List.of(1, 2);

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.empty());

        Optional<Usuario> result = usuarioService.atualizarInvestimentos(usuarioId, investimentoIds);

        assertTrue(result.isEmpty());
    }

    @Test
    void atualizarInvestimentos_investimentosNaoEncontrados_investimentosNaoAtualizados() {
        int usuarioId = 1;
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(usuarioId);
        usuario.setInvestimentos(new ArrayList<>());

        List<Integer> investimentoIds = List.of(1, 2);

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.of(usuario));
        when(investimentoRepo.findAllById(investimentoIds)).thenReturn(List.of());
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        Optional<Usuario> result = usuarioService.atualizarInvestimentos(usuarioId, investimentoIds);

        assertTrue(result.isPresent());
        assertTrue(result.get().getInvestimentos().isEmpty());
    }

    @Test
    void atualizarInvestimentos_investimentosEncontrado_investimentosAtualizados() {
        int usuarioId = 1;
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(usuarioId);
        usuario.setInvestimentos(new ArrayList<>());

        Investimento investimento1 = new Investimento();
        investimento1.setId_investimentos(1);

        Investimento investimento2 = new Investimento();
        investimento2.setId_investimentos(2);

        List<Integer> investimentoIds = List.of(1, 2);

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.of(usuario));
        when(investimentoRepo.findAllById(investimentoIds)).thenReturn(List.of(investimento1, investimento2));
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        Optional<Usuario> result = usuarioService.atualizarInvestimentos(usuarioId, investimentoIds);

        assertTrue(result.isPresent());
        Usuario updatedUsuario = result.get();
        assertEquals(2, updatedUsuario.getInvestimentos().size());
        assertTrue(updatedUsuario.getInvestimentos().containsAll(List.of(investimento1, investimento2)));
    }

    @Test
    void buscarInvestimentosPorUsuario_usuarioNaoEncontrado_retornarListaVazia() {
        int usuarioId = 1;

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.empty());

        List<Investimento> result = usuarioService.buscarInvestimentosPorUsuario(usuarioId);

        assertTrue(result.isEmpty());
    }

    @Test
    void buscarInvestimentosPorUsuario_usuarioComInvestimentos_retornarInvestimentos() {
        int usuarioId = 1;
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(usuarioId);
        usuario.setInvestimentos(List.of(new Investimento()));

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.of(usuario));

        List<Investimento> result = usuarioService.buscarInvestimentosPorUsuario(usuarioId);

        assertFalse(result.isEmpty());
    }

    @Test
    void calcularScore_semInvestimentos_scoreIgualZero() {
        int usuarioId = 1;

        Usuario usuario = new Usuario();
        usuario.setId_Usuario(usuarioId);
        usuario.setInvestimentos(List.of());

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.of(usuario));

        float score = usuarioService.calcularScore(usuarioId);

        assertEquals(0, score);
    }

    @Test
    void calcularScore_valoresValidos_scoreCalculado() {
        int usuarioId = 1;

        Investimento inv1 = new Investimento();
        inv1.setValor(84);
        Investimento inv2 = new Investimento();
        inv2.setValor(83);

        Usuario usuario = new Usuario();
        usuario.setId_Usuario(usuarioId);
        usuario.setInvestimentos(List.of(inv1, inv2));

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.of(usuario));

        float score = usuarioService.calcularScore(usuarioId);

        assertEquals(17, score);
    }

    @Test
    void atualizarScore_usuarioNaoEncontrado_retornarOptionalVazio() {
        int usuarioId = 1;
        int novoScore = 92;

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.empty());

        Optional<Usuario> result = usuarioService.atualizarScore(usuarioId, novoScore);

        assertTrue(result.isEmpty());
    }

    @Test
    void atualizarScore_usuarioExistente_scoreAtualizado() {
        int usuarioId = 1;
        int novoScore = 92;
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(usuarioId);

        when(usuarioRepo.findById(usuarioId)).thenReturn(Optional.of(usuario));
        when(usuarioRepo.save(usuario)).thenReturn(usuario);

        Optional<Usuario> result = usuarioService.atualizarScore(usuarioId, novoScore);

        assertTrue(result.isPresent());
        assertEquals(novoScore, result.get().getScore());
    }

    @Test
    void checarLogin_cpfCorretoESenhaIncorreta_retornaFalse() {
        Usuario usuario = new Usuario();
        usuario.setCpf("12345678900");
        usuario.setSenha("senhaSegura");

        LoginDTO login = new LoginDTO();
        login.setCpf("12345678900");
        login.setSenha("senhaErrada");

        boolean resultado = usuarioService.checarLogin(usuario, login);

        assertFalse(resultado);
    }

    @Test
    void checarLogin_cpfIncorretoESenhaCorreta_retornaFalse() {
        Usuario usuario = new Usuario();
        usuario.setCpf("12345678900");
        usuario.setSenha("senhaSegura");

        LoginDTO login = new LoginDTO();
        login.setCpf("98765432100");
        login.setSenha("senhaSegura");

        boolean resultado = usuarioService.checarLogin(usuario, login);

        assertFalse(resultado); 
    }

    @Test
    void checarLogin_cpfESenhaIncorretos_retornaFalse() {
        Usuario usuario = new Usuario();
        usuario.setCpf("12345678900");
        usuario.setSenha("senhaSegura");

        LoginDTO login = new LoginDTO();
        login.setCpf("98765432100");
        login.setSenha("senhaErrada");

        boolean resultado = usuarioService.checarLogin(usuario, login);

        assertFalse(resultado);
    }

    @Test
    void checarLogin_dadosIguais_retornaTrue() {
        Usuario usuario = new Usuario();
        usuario.setCpf("123456789");
        usuario.setSenha("senha123");

        LoginDTO login = new LoginDTO();
        login.setCpf("123456789");
        login.setSenha("senha123");

        boolean resultado = usuarioService.checarLogin(usuario, login);

        assertTrue(resultado);
    }

}
