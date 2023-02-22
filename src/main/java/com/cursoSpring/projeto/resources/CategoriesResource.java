package com.cursoSpring.projeto.resources;

import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {
  @Autowired
  private CategoryService categoryService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> findAll() {
    List<Category> response = categoryService.findAll();
    if (response == null) return ResponseEntity
      .status(HttpStatusCode.valueOf(400))
      .body(null);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> findById(@PathVariable Integer id) {
    Category response = categoryService.findById(id).orElse(null);
    if (response == null) return ResponseEntity
      .status(HttpStatusCode.valueOf(400))
      .body("Item not found!"); else return ResponseEntity.ok().body(response);
  }
}
