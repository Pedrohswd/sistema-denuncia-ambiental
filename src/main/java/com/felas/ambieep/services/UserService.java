package com.felas.ambieep.services;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User cadastrarUsuario(User usuario) {
        // lógica para cadastrar usuário
        return userRepository.save(usuario);
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

    public User atualizarUsuario(User usuario) {
        // lógica para atualizar usuário
        return userRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
