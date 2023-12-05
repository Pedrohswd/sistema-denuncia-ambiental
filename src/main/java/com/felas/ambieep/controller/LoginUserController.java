package com.felas.ambieep.controller;


import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.LoginJSON;
import com.felas.ambieep.services.LoginUserService;
import com.felas.ambieep.services.UserService;
import com.felas.ambieep.utils.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginUserController {
    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private UserService userService;

    @PostMapping("/log")
    public ResponseEntity<User> loginUser(@RequestBody LoginJSON loginJSON){
        if(loginUserService.logonUser(loginJSON)){
            return ResponseEntity.ok(userService.findUserbyCPF(CPF.retirarMascara(loginJSON.cpf())));
        } else{
            return null;
        }
    }

    @PostMapping("/autenticate")
    public boolean loginCheck(@RequestBody LoginJSON loginJSON){
        if(loginUserService.loginCheck(loginJSON)){
            return true;
        }
        return false;
    }

    @PostMapping("/logoff")
    public boolean logoff(@RequestBody LoginJSON loginJSON){
        if(loginUserService.logoffUser(loginJSON)){
            return true;
        }
        return false;
    }
}
