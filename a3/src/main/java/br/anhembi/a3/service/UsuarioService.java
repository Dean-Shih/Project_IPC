package br.anhembi.a3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.a3.model.Usuario;
import br.anhembi.a3.repository.UsuarioRepo;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repo;

    //TODO:
    // Checar outros parametrs além do ID na criação
    public Optional<Usuario> create(Usuario usuario){
        if(usuario.getId() != 0){
            return Optional.empty();
        }
        return Optional.of(repo.save(usuario));
    }

    public Optional<Usuario> findById(int id) {
        return repo.findById(id);
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) repo.findAll();
    }

    public boolean delete(int id) {
        if(id <= 0) {
            return false;
        }
        Optional<Usuario> usuarioOptional = repo.findById(id);

        if(usuarioOptional.isEmpty()) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public Optional<Usuario> update(Usuario usuario) {
        if(usuario.getId() <= 0) {
            return Optional.empty();
        }
        Optional<Usuario> usuarioOptional = repo.findById(usuario.getId());

        if(usuarioOptional.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(repo.save(usuario));
    }

    
}
