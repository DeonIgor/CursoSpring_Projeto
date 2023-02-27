package com.cursoSpring.projeto;

import com.cursoSpring.projeto.domain.Address;
import com.cursoSpring.projeto.domain.Category;
import com.cursoSpring.projeto.domain.City;
import com.cursoSpring.projeto.domain.Client;
import com.cursoSpring.projeto.domain.Product;
import com.cursoSpring.projeto.domain.State;
import com.cursoSpring.projeto.enums.ClientType;
import com.cursoSpring.projeto.repositories.AddressRepository;
import com.cursoSpring.projeto.repositories.CategoryRepository;
import com.cursoSpring.projeto.repositories.CityRepository;
import com.cursoSpring.projeto.repositories.ClientRepository;
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

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private AddressRepository addressRepository;

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

    Client cli1 = new Client(
      null,
      "Fernando",
      "fernando@gmail.com",
      "693.192.018-97",
      ClientType.PESSOAFISICA
    );

    Address ad1 = new Address(
      null,
      "Rua Santa Efigenia",
      "67",
      "Casa",
      "Bairro das Rosas",
      "65046-306",
      city1,
      cli1
    );
    Address ad2 = new Address(
      null,
      "Rua Mongolia",
      "251",
      "Ap 505, Torre 3",
      "Bairro Industrial",
      "65557-674",
      city3,
      cli1
    );

    cli1.getAdresses().addAll(Arrays.asList(ad1, ad2));

    clientRepository.saveAll(Arrays.asList(cli1));
    addressRepository.saveAll(Arrays.asList(ad1, ad2));
  }
}
