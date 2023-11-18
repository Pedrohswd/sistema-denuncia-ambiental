package com.felas.ambieep.config;

import com.felas.ambieep.entites.User;
import com.felas.ambieep.entites.enums.Permission;
import com.felas.ambieep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1L, "04019822212", "12345", "Pedro Henrique", "2312131",Permission.ANALISTA);
        User u2 = new User(2L, "0401242213", "12345", "Emilly Duarte","234412", Permission.DENUNCIANTE);
        User u3 = new User(3L, "2301242213", "12345", "Eduardo Candido", "2312112",Permission.DENUNCIANTE);
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

    }
}
