package br.gov.sp.cps.ProjetoSpringIoC.controller;

import br.gov.sp.cps.ProjetoSpringIoC.entity.Usuario;
import br.gov.sp.cps.ProjetoSpringIoC.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable Long id) {
        usuarioService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletartodos")
    public ResponseEntity<Void> deleteAll() {
        usuarioService.deletarTodos();
        return ResponseEntity.noContent().build();
    }
}
