package com.example.demo.repository;

import com.example.demo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findById(Long id);

    List<Category> findAll();

    Category save(Category category);
}
