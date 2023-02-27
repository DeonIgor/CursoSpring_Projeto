package com.cursoSpring.projeto.resources;

import com.cursoSpring.projeto.domain.Client;
import com.cursoSpring.projeto.services.ClientService;
import com.cursoSpring.projeto.services.exceptions.ObjectNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
  @Autowired
  private ClientService clientService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> findAll() {
    List<Client> response = clientService.findAll();
    if (response == null) return ResponseEntity
      .status(HttpStatusCode.valueOf(400))
      .body(null);
    return ResponseEntity.ok().body(response);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> findById(@PathVariable Integer id)
    throws ObjectNotFoundException {
    Client response = clientService.findById(id);
    return ResponseEntity.ok().body(response);
  }
}
