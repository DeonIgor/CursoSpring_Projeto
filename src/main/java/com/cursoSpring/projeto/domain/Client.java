package com.cursoSpring.projeto.domain;

import com.cursoSpring.projeto.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String email;
  private String cpfOrCnpj;
  private Integer type;

  @JsonManagedReference
  @OneToMany(mappedBy = "client")
  private List<Address> adresses = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "TELEFONE")
  private Set<String> phones = new HashSet<>();

  public Client() {}

  public Client(
    Integer id,
    String name,
    String email,
    String cpfOrCnpj,
    ClientType type
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.cpfOrCnpj = cpfOrCnpj;
    this.type = type.getCod();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpfOrCnpj() {
    return this.cpfOrCnpj;
  }

  public void setCpfOrCnpj(String cpfOrCnpj) {
    this.cpfOrCnpj = cpfOrCnpj;
  }

  public ClientType getType() {
    return ClientType.toClientType(this.type);
  }

  public void setType(ClientType type) {
    this.type = type.getCod();
  }

  public List<Address> getAdresses() {
    return this.adresses;
  }

  public void setAdresses(List<Address> adresses) {
    this.adresses = adresses;
  }

  public Set<String> getPhones() {
    return this.phones;
  }

  public void setPhones(Set<String> phones) {
    this.phones = phones;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Client)) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(id, client.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
