package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<LoginUser, Long> {
}
