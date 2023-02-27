package com.cursoSpring.projeto.repositories;

import com.cursoSpring.projeto.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {}
