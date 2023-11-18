package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.LoginUser;
import com.felas.ambieep.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    LoginUser findByCpf(String cpf);
    boolean findByCpfBollean(String cpf);
}
