package com.wellyngton.storestok.service;

import com.wellyngton.storestok.model.Category;
import com.wellyngton.storestok.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
