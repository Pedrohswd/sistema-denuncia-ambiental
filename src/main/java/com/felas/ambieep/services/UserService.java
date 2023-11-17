package com.felas.ambieep.services;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.records.NewUserRecordJSON;
import com.felas.ambieep.entites.records.UpdateUserRecordJSON;
import com.felas.ambieep.repositories.UserRepository;
import com.felas.ambieep.utils.CPF;
import com.felas.ambieep.utils.CriptoHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User cadastrarUsuario(NewUserRecordJSON userJSON) {
        User user = new User();
        user.setCpf(CPF.retirarMascara(userJSON.cpf()));
        user.setPassword(CriptoHash.hashPassword(userJSON.password()));
        user.setName(userJSON.name());
        user.setPhone(userJSON.phone());
        user.setPermission(userJSON.permission());
        return userRepository.save(user);
    }

    public User buscarUsuarioPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User buscarUsuarioPorCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User atualizarUsuario(UpdateUserRecordJSON userRecordJSON) {
        User user = userRepository.findByCpf(userRecordJSON.cpf());
        user.setName(userRecordJSON.name());
        user.setPhone(userRecordJSON.phone());
        return userRepository.save(user);
    }

    public void excluirUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
