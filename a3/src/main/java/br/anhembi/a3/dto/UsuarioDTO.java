package br.anhembi.a3.dto;

import br.anhembi.a3.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private int id;
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    private String cpf;
    private String telefone;
    private String email;
    
    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;
    private int score;

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId_Usuario();
        nome = usuario.getNome();
        cpf = usuario.getCpf();
        telefone = usuario.getTelefone();
        email = usuario.getEmail();
        score = usuario.getScore();
    }

    public Usuario toUsuario(){
        return new Usuario(this.nome, this.cpf, this.telefone, this.email, this.senha, this.score);
    }
}
