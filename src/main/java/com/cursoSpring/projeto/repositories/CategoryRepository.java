package com.cursoSpring.projeto.repositories;

import com.cursoSpring.projeto.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}
