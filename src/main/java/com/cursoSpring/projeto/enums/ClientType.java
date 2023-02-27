package com.cursoSpring.projeto.enums;

public enum ClientType {
  PESSOAFISICA(1, "Pessoa Física"),
  PESSOAJURIDICA(2, "Pessoa Jurídica");

  private Integer cod;
  private String description;

  private ClientType(Integer cod, String description) {
    this.cod = cod;
    this.description = description;
  }

  public Integer getCod() {
    return cod;
  }

  public String getDescription() {
    return description;
  }

  public static ClientType toClientType(Integer type) {
    for (ClientType ct : ClientType.values()) {
      if (ct.cod == type) return ct;
    }
    return null;
  }
}
