package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRespoitory categoryRespoitory;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return categoryRespoitory.findAll().stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
    }
}
