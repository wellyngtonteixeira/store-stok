package com.wellyngton.storestok.controller;

import com.wellyngton.storestok.model.Category;
import com.wellyngton.storestok.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Category>> getAllCategories(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll(pageable));
    }


}
