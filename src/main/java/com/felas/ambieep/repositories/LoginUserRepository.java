package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    LoginUser findByCpf(String cpf);
}
