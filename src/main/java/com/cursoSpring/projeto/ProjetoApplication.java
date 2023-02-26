package com.cursoSpring.projeto;

import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.domain.City;
import com.cursoSpring.projeto.domain.Product;
import com.cursoSpring.projeto.domain.State;
import com.cursoSpring.projeto.repositories.CategoryRepository;
import com.cursoSpring.projeto.repositories.CityRepository;
import com.cursoSpring.projeto.repositories.ProductRepository;
import com.cursoSpring.projeto.repositories.StateRepository;
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

  @Autowired
  private StateRepository stateRepository;

  @Autowired
  private CityRepository cityRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProjetoApplication.class, args);
  }

  public void run(String... args) throws Exception {
    // Relacoes de produtos e categorias

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

    // Relacoes de cidades e estados

    State state1 = new State(null, "Minas Gerais");
    State state2 = new State(null, "São Paulo");

    City city1 = new City(null, "Uberlândia", state1);
    City city2 = new City(null, "Campinas", state2);
    City city3 = new City(null, "Ubatuba", state2);

    state1.getCities().addAll(Arrays.asList(city1));
    state2.getCities().addAll(Arrays.asList(city2, city3));

    stateRepository.saveAll(Arrays.asList(state1, state2));
    cityRepository.saveAll(Arrays.asList(city1, city2, city3));
  }
}
