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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Usuario;

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private int score;

    @ManyToMany
    @JoinTable(
        name = "relacao",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_investimento")
    )
    @JsonIgnoreProperties("usuarios")
    private List<Investimento> investimentos;


    public Usuario(String nome, String cpf, String telefone, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public void addInvestimento(Iterable<Investimento> investimentos){
        investimentos.forEach(this.investimentos::add);
    }
}
