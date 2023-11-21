package com.felas.ambieep.services;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.NewUserRecordJSON;
import com.felas.ambieep.entites.records.UpdateUserRecordJSON;
import com.felas.ambieep.repositories.UserRepository;
import com.felas.ambieep.utils.CPF;
import com.felas.ambieep.utils.CriptoHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registryUser(NewUserRecordJSON userJSON) {
        User user = new User();
        user.setCpf(CPF.retirarMascara(userJSON.cpf()));
        user.setPassword(CriptoHash.hashPassword(userJSON.password()));
        user.setName(userJSON.name());
        user.setPhone(userJSON.phone());
        user.setPermission(userJSON.permission());
        userRepository.save(user);
        user.setPassword("");
        return user;
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    public User findUserbyCPF(String cpf) {
        User user = userRepository.findByCpf(cpf);
        user.setPassword("");
        return user;
    }

    public User updateUser(UpdateUserRecordJSON userRecordJSON) {
        User user = userRepository.findByCpf(userRecordJSON.cpf());
        user.setName(userRecordJSON.name());
        user.setPhone(userRecordJSON.phone());
        userRepository.save(user);
        user.setPassword("");
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
