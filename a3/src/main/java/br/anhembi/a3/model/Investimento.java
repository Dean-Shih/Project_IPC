package br.anhembi.a3.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Investimento {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String nome;
    private int pontuação;

    @ManyToMany(mappedBy = "investimentos")
    @JsonIgnoreProperties("investimentos")
    private List<Usuario> usuarios;

    public void addUsuarios(Usuario usuario){
        this.usuarios.add(usuario);
    }
}
