package com.felas.ambieep.controller;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.user.NewUserRecordJSON;
import com.felas.ambieep.entites.records.user.UpdateUserRecordJSON;
import com.felas.ambieep.services.UserService;
import com.felas.ambieep.utils.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registryUser(@RequestBody NewUserRecordJSON user) {
        if (CPF.validarCPF(CPF.retirarMascara(user.cpf()))){
            User newUser = userService.registryUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> findUserbyCPF(@PathVariable String cpf) {
        User usuario = userService.findUserbyCPF(cpf);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRecordJSON userRecordJSON) {
        User userUpdated = userService.updateUser(userRecordJSON);
        return ResponseEntity.ok(userUpdated);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
