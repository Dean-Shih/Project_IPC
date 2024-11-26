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
    private int Id_Usuario;

    private String Nome;
    private String Cpf;
    private String Telefone;
    private String Email;
    private String Senha;
    private int Score;

    @ManyToMany
    @JoinTable(
        name = "relacao",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_investimento")
    )
    @JsonIgnoreProperties("usuarios")
    private List<Investimento> investimentos;


    public Usuario(String nome, String cpf, String telefone, String email, String senha, int score) {
        this.Nome = nome;
        this.Cpf = cpf;
        this.Telefone = telefone;
        this.Email = email;
        this.Senha = senha;
        this.Score = score;
    }

    public void addInvestimento(Iterable<Investimento> investimentos){
        investimentos.forEach(this.investimentos::add);
    }
}
