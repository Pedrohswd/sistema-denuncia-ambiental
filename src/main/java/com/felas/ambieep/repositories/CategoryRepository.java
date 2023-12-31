package com.felas.ambieep.repositories;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT c FROM Category c WHERE c.categoryType = :type")
    List<Category> findByType(@Param("type") CategoryType type);

    @Query(value = "SELECT c FROM Category c WHERE c.description = :description")
    Category findByDescription(@Param("description") String description);
}
