package br.anhembi.a3.dto;

import br.anhembi.a3.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    private String cpf;
    private String telefone;
    private String email;
    
    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;
    private int score;

    public Usuario toUsuario(){
        return new Usuario(this.nome, this.cpf, this.telefone, this.email, this.senha, this.score);
    }
}
