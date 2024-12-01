package br.anhembi.a3.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.anhembi.a3.model.Investimento;
import br.anhembi.a3.repository.InvestimentoRepo;

public class InvestimentoServiceTest {
   
    @Mock
    private InvestimentoRepo repo;

    @InjectMocks
    private InvestimentoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void findById_encontrado_investimentoExiste() {
        int id = 1;
        Investimento mockInvestimento = new Investimento();
        mockInvestimento.setId_investimentos(id);
        mockInvestimento.setNome("Investimento Teste");

        when(repo.findById(id)).thenReturn(Optional.of(mockInvestimento));

        Optional<Investimento> result = service.findById(id);

        assertTrue(result.isPresent());
    }

    @Test
    void findById_naoEncontrado_investimentoInexistente() {
        int id = 0;

        when(repo.findById(id)).thenReturn(Optional.empty());

        Optional<Investimento> result = service.findById(id);

        assertFalse(result.isPresent());
    }
}

