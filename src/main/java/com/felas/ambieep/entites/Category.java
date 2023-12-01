package com.felas.ambieep.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felas.ambieep.entites.enums.CategoryType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categ")
    private Long id;
    @Column(length = 8000, name = "description_categ")
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    @OneToMany(mappedBy = "category")
    private List<Denunciation> denunciations;

    public Category(){

    }

    public Category(Long id, String description, CategoryType categoryType) {
        this.id = id;
        this.description = description;
        this.categoryType = categoryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getCategoryEnum() {
        return categoryType;
    }

    public void setCategoryEnum(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
