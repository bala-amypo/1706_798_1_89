package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Category;

public interface CategoryService {

    Category create(Category category);

    List<Category> getAll();

    Category getById(Long id);
}
