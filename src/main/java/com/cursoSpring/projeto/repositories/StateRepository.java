package com.cursoSpring.projeto.repositories;

import com.cursoSpring.projeto.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {}
