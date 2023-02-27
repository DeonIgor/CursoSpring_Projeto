package com.cursoSpring.projeto.services;

import com.cursoSpring.projeto.domain.Client;
import com.cursoSpring.projeto.repositories.ClientRepository;
import com.cursoSpring.projeto.services.exceptions.ObjectNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  public Client findById(Integer id) throws ObjectNotFoundException {
    Client obj = clientRepository.findById(id).orElse(null);

    if (obj == null) throw new ObjectNotFoundException(
      "Item not found! id: " + id + " in " + Client.class
    );
    return obj;
  }
}
