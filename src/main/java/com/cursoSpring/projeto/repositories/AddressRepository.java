package com.cursoSpring.projeto.repositories;

import com.cursoSpring.projeto.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {}
