package com.cursoSpring.projeto;

import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.domain.Product;
import com.cursoSpring.projeto.repositories.CategoryRepository;
import com.cursoSpring.projeto.repositories.ProductRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProjetoApplication.class, args);
  }

  public void run(String... args) throws Exception {
    Product prod1 = new Product(null, "Computador", 2200.00);
    Product prod2 = new Product(null, "Impressora", 800.00);
    Product prod3 = new Product(null, "Mouse", 80.00);

    Category cat1 = new Category(null, "Informática");
    Category cat2 = new Category(null, "Escritório");

    cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
    cat2.getProducts().addAll(Arrays.asList(prod2));

    prod1.getCategories().addAll(Arrays.asList(cat1));
    prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
    prod3.getCategories().addAll(Arrays.asList(cat1));

    categoryRepository.saveAll(Arrays.asList(cat1, cat2));
    productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
  }
}
