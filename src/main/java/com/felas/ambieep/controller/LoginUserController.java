package com.felas.ambieep.controller;

import com.felas.ambieep.entites.LoginUser;
import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.LoginJSON;
import com.felas.ambieep.services.LoginUserService;
import com.felas.ambieep.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginUserController {
    @Autowired
    private LoginUserService loginUserService;

    @PostMapping
    public boolean loginUser(@RequestBody LoginJSON loginJSON){
        if(loginUserService.logonUser(loginJSON)){
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
