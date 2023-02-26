package com.cursoSpring.projeto.repositories;

import com.cursoSpring.projeto.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {}
