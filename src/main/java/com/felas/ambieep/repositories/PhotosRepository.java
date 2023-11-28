package com.felas.ambieep.repositories;


import com.felas.ambieep.entites.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PhotosRepository extends JpaRepository<Photos, Long> {
    @Query(value = "SELECT * FROM Photos WHERE denunciation_id = :id", nativeQuery = true)
    public List<Photos> findByDenunciationId(@Param("id") Long id);
}
