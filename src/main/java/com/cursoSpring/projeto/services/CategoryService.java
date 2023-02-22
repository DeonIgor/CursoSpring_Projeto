package com.cursoSpring.projeto.services;

import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Optional<Category> findById(Integer id) {
    return categoryRepository.findById(id);
  }
}
