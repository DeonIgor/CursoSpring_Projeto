package com.cursoSpring.projeto;

import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.repositories.CategoryRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {
  @Autowired
  private CategoryRepository categoryRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProjetoApplication.class, args);
  }

  public void run(String... args) throws Exception {
    Category cat1 = new Category(null, "cat1");
    Category cat2 = new Category(null, "cat2");

    categoryRepository.saveAll(Arrays.asList(cat1, cat2));
  }
}
