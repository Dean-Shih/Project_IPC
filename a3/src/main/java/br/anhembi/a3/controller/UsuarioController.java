package br.anhembi.a3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.a3.dto.InvestimentoLinkDTO;
import br.anhembi.a3.dto.UsuarioDTO;
import br.anhembi.a3.model.Usuario;
import br.anhembi.a3.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody @Valid UsuarioDTO usuarioDto) {
        Optional<Usuario> optionalUsuario = usuarioService.create(usuarioDto.toUsuario());

        if(optionalUsuario.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Usuario>(optionalUsuario.get(), 
            HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);

        if(usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios =usuarioService.findAll();

        if(usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable int id) {
        boolean deleted = usuarioService.delete(id);

        if(deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioService.update(usuario);

        if(usuarioOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Usuario>(usuarioOptional.get(), HttpStatus.OK);
    }

    @PatchMapping("/{id}/investimentos")
    public ResponseEntity<Usuario> atualizarInvestimentos(@PathVariable int id,@RequestBody InvestimentoLinkDTO dto) {

        Optional<Usuario> usuarioAtualizado = usuarioService.atualizarInvestimentos(id, dto.getInvestimentoIds());

        if(usuarioAtualizado.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Usuario>(usuarioAtualizado.get(), HttpStatus.OK);
    }
}

