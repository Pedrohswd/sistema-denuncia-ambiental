package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.Denunciation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciationRepository extends JpaRepository<Denunciation, Long> {
}
