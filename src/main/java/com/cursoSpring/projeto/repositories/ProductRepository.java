package com.cursoSpring.projeto.repositories;

import com.cursoSpring.projeto.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
