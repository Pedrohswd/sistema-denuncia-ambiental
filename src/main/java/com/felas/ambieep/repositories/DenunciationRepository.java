package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.Denunciation;
import com.felas.ambieep.entites.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DenunciationRepository extends JpaRepository<Denunciation, Long> {
    @Query(value = "SELECT * FROM Denunciation WHERE n_protocol = :protocol", nativeQuery = true)
    public Denunciation findByNProtocol(@Param("protocol") String nProtocol);

    @Query(value = "SELECT * " +
            "FROM denunciation d " +
            "LEFT JOIN category c ON d.category_id = c.id_categ " +
            "LEFT JOIN address a ON d.address_id = a.id_adr " +
            "LEFT JOIN users u ON d.users_id = u.id_usr " +
            "WHERE " +
            "(:categoryType ISNULL OR CAST(c.category_type AS VARCHAR) = CAST(:categoryType AS VARCHAR)) " +
            "AND (:conty ISNULL OR a.county = CAST(:conty AS VARCHAR)) " +
            "AND (:state ISNULL OR a.state = CAST(:state AS INTEGER)) " +
            "AND (:category ISNULL OR d.category_id = CAST(:category AS BIGINT)) " +
            "AND (:cpf ISNULL OR CAST(u.cpf AS VARCHAR) = CAST(:cpf AS VARCHAR)) " +
            "AND (:dateReg ISNULL OR CAST(d.date_created AS VARCHAR) = CAST(:dateReg AS VARCHAR)) " +
            "AND (:dateFact ISNULL OR CAST(d.date_fact AS VARCHAR) = CAST(:dateFact AS VARCHAR)) " +
            "AND (:situation ISNULL OR CAST(d.situation AS VARCHAR) = CAST(:situation AS VARCHAR))",
            nativeQuery = true)
    public List<Denunciation> findyByParameters(@Param("categoryType") String categoryType,
                                                @Param("conty") String conty,
                                                @Param("state") String state,
                                                @Param("category") Long category,
                                                @Param("cpf") String cpf,
                                                @Param("dateReg") String dateReg,
                                                @Param("dateFact") String dateFact,
                                                @Param("situation") String situation);

}
