package com.cursoSpring.projeto.resources;

import com.cursoSpring.projeto.domain.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

  @RequestMapping(method = RequestMethod.GET)
  public List<Category> listAll() {
    Category cat1 = new Category(1, "Categoria 1");
    Category cat2 = new Category(2, "Categoria 2");
    List<Category> list = new ArrayList<Category>();

    list.add(cat1);
    list.add(cat2);

    return list;
  }
}
