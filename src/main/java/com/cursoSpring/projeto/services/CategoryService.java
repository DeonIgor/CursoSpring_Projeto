package com.cursoSpring.projeto.services;

import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.repositories.CategoryRepository;
import com.cursoSpring.projeto.services.exceptions.ObjectNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Integer id) throws ObjectNotFoundException {
    Category obj = categoryRepository.findById(id).orElse(null);

    if (obj == null) throw new ObjectNotFoundException(
      "Item not found! id: " + id + " in " + Category.class
    );
    return obj;
  }
}
