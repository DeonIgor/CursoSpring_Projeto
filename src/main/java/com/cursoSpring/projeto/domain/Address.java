package com.cursoSpring.projeto.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String street;
  private String number;
  private String complement;
  private String district;
  private String cep;

  @OneToOne
  @JoinColumn(name = "city_id")
  private City city = new City();

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  public Address() {}

  public Address(
    Integer id,
    String street,
    String number,
    String complement,
    String district,
    String cep,
    City city,
    Client client
  ) {
    this.id = id;
    this.street = street;
    this.number = number;
    this.complement = complement;
    this.district = district;
    this.cep = cep;
    this.city = city;
    this.client = client;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getComplement() {
    return this.complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getDistrict() {
    return this.district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public City getCity() {
    return this.city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Address)) {
      return false;
    }
    Address adress = (Address) o;
    return Objects.equals(id, adress.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
