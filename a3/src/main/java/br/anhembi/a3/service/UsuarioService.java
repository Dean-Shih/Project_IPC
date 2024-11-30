package br.anhembi.a3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.a3.dto.LoginDTO;
import br.anhembi.a3.model.Investimento;
import br.anhembi.a3.model.Usuario;
import br.anhembi.a3.repository.InvestimentoRepo;
import br.anhembi.a3.repository.UsuarioRepo;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private InvestimentoRepo invRepo;

    //TODO:
    // Checar outros parametrs além do ID na criação
    public Optional<Usuario> create(Usuario usuario){
        if(usuario.getId_Usuario() != 0){
            return Optional.empty();
        }
        return Optional.of(usuarioRepo.save(usuario));
    }

    public Optional<Usuario> findById(int id) {
        return usuarioRepo.findById(id);
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepo.findAll();
    }

    public Optional<Usuario> findByCpf(String cpf){
        return usuarioRepo.findByCpf(cpf);
    }

    public boolean delete(int id) {
        if(id <= 0) {
            return false;
        }
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);

        if(usuarioOptional.isEmpty()) {
            return false;
        }
        usuarioRepo.deleteById(id);
        return true;
    }

    public Optional<Usuario> update(Usuario usuario) {
        if(usuario.getId_Usuario() <= 0) {
            return Optional.empty();
        }
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(usuario.getId_Usuario());

        if(usuarioOptional.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(usuarioRepo.save(usuario));
    }

    public Optional<Usuario> atualizarInvestimentos(int usuarioId, List<Integer> investimentoIds) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(usuarioId);
        if(usuarioOptional.isEmpty()){
            return Optional.empty();
        }
        Usuario usuario = usuarioOptional.get();

        usuario.getInvestimentos().clear();

        Iterable<Investimento> investimentos = invRepo.findAllById(investimentoIds);

        usuario.addInvestimento(investimentos);

        return Optional.of(usuarioRepo.save(usuario));
    }

    public List<Investimento> buscarInvestimentosPorUsuario(int usuarioId) {
        Optional<Usuario> usuario = usuarioRepo.findById(usuarioId);
        if(usuario.isEmpty()){
            return List.of();
        }

        return usuario.get().getInvestimentos();
    }

    public Float calcularScore(int usuarioId) {
        List<Investimento> investimentos = buscarInvestimentosPorUsuario(usuarioId);
        float Score = 0;

        for (Investimento investimento : investimentos) {
            Score += investimento.getValor();
        }
        System.out.println(Score);

        Score = ((Score/1000) * 100);
        Math.ceil(Score);

        return Score;
    }

    public Optional<Usuario> atualizarScore(int usuarioId, int novoScore) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(usuarioId);

        if(usuarioOptional.isEmpty()){
            return Optional.empty();
        }
        Usuario usuario = usuarioOptional.get();

        usuario.setScore(novoScore);
        return Optional.of(usuarioRepo.save(usuario)); 
    }

    public boolean checarLogin(Usuario usuario, LoginDTO login){
        boolean loginRealizado = usuario.getCpf().equals(login.getCpf()) && usuario.getSenha().equals(login.getSenha());
        if(loginRealizado){
            login.setId(usuario.getId_Usuario());
        }
        return loginRealizado;
    }
}

