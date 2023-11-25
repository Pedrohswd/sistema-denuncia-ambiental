package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.Denunciation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DenunciationRepository extends JpaRepository<Denunciation, Long> {
    @Query(value = "SELECT * FROM Denunciation WHERE n_protocol = :protocol", nativeQuery = true)
    public Denunciation findByNProtocol(@Param("protocol") String nProtocol);
}
