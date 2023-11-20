package com.felas.ambieep.services;

import com.felas.ambieep.entites.LoginUser;
import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.LoginJSON;
import com.felas.ambieep.repositories.LoginUserRepository;
import com.felas.ambieep.repositories.UserRepository;
import com.felas.ambieep.utils.CPF;
import com.felas.ambieep.utils.CriptoHash;
import com.felas.ambieep.utils.Dates;
import com.felas.ambieep.utils.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginUserRepository loginUserRepository;

    public boolean logonUser(LoginJSON loginJSON) {
        if (userRepository.findByCpf(CPF.retirarMascara(loginJSON.cpf())) != null) {
            User user = userRepository.findByCpf(CPF.retirarMascara(loginJSON.cpf()));
            if (Password.validatePass(user.getPassword(), CriptoHash.hashPassword(loginJSON.password()))) {
                if (loginUserRepository.findByCpf(user.getCpf()) == null) {
                    LoginUser lg = new LoginUser(null,user.getCpf(), Dates.now());
                    loginUserRepository.save(lg);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean logoffUser(LoginJSON loginJSON){
        User user = userRepository.findByCpf(CPF.retirarMascara(loginJSON.cpf()));
        if(loginUserRepository.findByCpf(user.getCpf()) != null){
            loginUserRepository.deleteById(loginUserRepository.findByCpf(user.getCpf()).getId());
            return true;
        }
        return false;
    }

    public boolean loginCheck(LoginJSON loginJSON){
        User user = userRepository.findByCpf(CPF.retirarMascara(loginJSON.cpf()));
        if(loginUserRepository.findByCpf(user.getCpf()) != null){
            return true;
        }
        return false;
    }
}
