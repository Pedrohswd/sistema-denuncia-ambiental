package com.felas.ambieep.controller;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list/{category}")
    public ResponseEntity<List<Category>> listCategoryByType(@PathVariable String category){
        List<Category> listCategory = categoryService.findByType(category);
        return ResponseEntity.ok(listCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findCategory(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
}
