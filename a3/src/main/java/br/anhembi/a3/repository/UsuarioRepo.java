package br.anhembi.a3.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.a3.model.Usuario;

public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{

}
