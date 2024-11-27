package br.anhembi.a3.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.a3.model.Usuario;


public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{
    Optional<Usuario> findByCpf(String cpf);
}   
