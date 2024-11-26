package br.anhembi.a3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Integer calcularScore(int usuarioId) {
        List<Investimento> investimentos = buscarInvestimentosPorUsuario(usuarioId);
        int Score = 0;

        for (Investimento investimento : investimentos) {
            //CALCULO DE SCORE AQUI
        }

        return Score;
    }
}

