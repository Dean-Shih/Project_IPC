package br.anhembi.a3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String cpf;
    private String senha;
    private int id;
    private boolean liberado;
}
