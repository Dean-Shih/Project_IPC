package br.anhembi.a3.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "investimentos")
public class Investimento {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int Id_investimentos;

    private String Nome;
    private int Valor;

    @ManyToMany(mappedBy = "investimentos")
    @JsonIgnoreProperties("investimentos")
    private List<Usuario> usuarios;
}
