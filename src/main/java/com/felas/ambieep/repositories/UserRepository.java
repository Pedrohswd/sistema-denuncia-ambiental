package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
    boolean findByCpfBollean(String cpf);

}
