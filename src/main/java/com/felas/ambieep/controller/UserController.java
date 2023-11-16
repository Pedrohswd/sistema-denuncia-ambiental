package com.felas.ambieep.controller;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User usuario) {
        User novoUsuario = userService.cadastrarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuarioPorId(@PathVariable Long id) {
        User usuario = userService.buscarUsuarioPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> buscarUsuarioPorCpf(@PathVariable String cpf) {
        User usuario = userService.buscarUsuarioPorCpf(cpf);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> listarUsuarios() {
        List<User> usuarios = userService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/update")
    public ResponseEntity<User> atualizarUsuario(@RequestBody User usuario) {
        User usuarioAtualizado = userService.atualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        userService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
