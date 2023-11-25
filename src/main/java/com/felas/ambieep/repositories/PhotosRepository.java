package com.felas.ambieep.repositories;


import com.felas.ambieep.entites.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<Photos, Long> {
}
