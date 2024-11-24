package br.anhembi.a3.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.a3.model.Investimento;

public interface InvestimentoRepo extends CrudRepository<Investimento, Integer>{
    
}
