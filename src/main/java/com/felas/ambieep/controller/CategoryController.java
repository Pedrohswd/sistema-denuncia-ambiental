package com.felas.ambieep.controller;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.enums.CategoryType;
import com.felas.ambieep.entites.records.CategoryJSON;
import com.felas.ambieep.entites.records.LoginJSON;
import com.felas.ambieep.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategoryByType(@RequestBody CategoryJSON categoryJSON){
        List<Category> listCategory = categoryService.findByType(categoryJSON);
        return ResponseEntity.ok(listCategory);
    }
}
