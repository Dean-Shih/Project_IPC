package br.anhembi.a3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.a3.model.Investimento;
import br.anhembi.a3.repository.InvestimentoRepo;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepo repo;

    public Optional<Investimento> findById(int id) {
        return repo.findById(id);
    }
}
