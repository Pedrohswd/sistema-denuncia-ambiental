package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.Denunciation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DenunciationRepository extends JpaRepository<Denunciation, Long> {
    @Query(value = "SELECT * FROM Denunciation WHERE n_protocol = :protocol", nativeQuery = true)
    public Denunciation findByNProtocol(@Param("protocol") String nProtocol);

    @Query("SELECT d FROM Denunciation d " +
            "WHERE (:categoryType IS NULL OR d.category.categoryType = :categoryType) " +
            "AND (:conty IS NULL OR d.address.county = :conty) " +
            "AND (:state IS NULL OR d.address.state = :state) " +
            "AND (:category IS NULL OR d.category =:category)"+
            "AND (:cpf IS NULL OR d.user.cpf =:cpf)"+
            "AND (:dateReg IS NULL OR d.dateCreated =:dateReg)"+
            "AND (:dateFact IS NULL OR d.dateFact =:dateFact)"+
            "AND (:situation IS NULL OR d.situation =:situation)")
    public List<Denunciation> findyByParameters(@Param("categoryType") String categoria,
                                                @Param("conty") String cidade,
                                                @Param("state") String estado,
                                                @Param("category") Long category,
                                                @Param("cpf") String cpf,
                                                @Param("dateReg")Date dateReg,
                                                @Param("dateFact")Date dateFact,
                                                @Param("situation")String situation);

}
