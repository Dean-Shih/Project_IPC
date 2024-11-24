package br.anhembi.a3.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String documento;
    private String telefone;
    private String email;
    private String senha;
    private int score;

    @ManyToMany
    @JoinTable(
        name = "investimento_usuario",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_investimento")
    )
    @JsonIgnoreProperties("usuarios")
    private List<Investimento> investimentos;


    public Usuario(String nome, String documento, String telefone, String email, String senha, int score) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.score = score;
    }

    public void addInvestimento(Investimento investimento){
        this.investimentos.add(investimento);
    }
}
