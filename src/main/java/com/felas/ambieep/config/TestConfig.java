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
        User u1 = new User(1L, "04019822212", "3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79", "Pedro Henrique", "2312131",Permission.ANALISTA);
        User u2 = new User(2L, "04012422213", "3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79", "Emilly Duarte","234412", Permission.DENUNCIANTE);
        User u3 = new User(3L, "23012422313", "3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79", "Eduardo Candido", "2312112",Permission.DENUNCIANTE);
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

    }
}
