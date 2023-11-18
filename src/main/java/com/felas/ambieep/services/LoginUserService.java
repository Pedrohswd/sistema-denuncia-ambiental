package com.felas.ambieep.services;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.LoginJSON;
import com.felas.ambieep.repositories.LoginUserRepository;
import com.felas.ambieep.repositories.UserRepository;
import com.felas.ambieep.utils.CriptoHash;
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
//        if (userRepository.findByCpfBollean(loginJSON.cpf())) {
//            User user = userRepository.findByCpf(loginJSON.cpf());
//            if (Password.validatePass(user.getPassword(), CriptoHash.hashPassword(loginJSON.password()))) {
//                if (loginUserRepository.findByCpfBollean(user.getCpf())) {
//                    return true;
//                }
//            }
//        }
        return false;
    }
}
