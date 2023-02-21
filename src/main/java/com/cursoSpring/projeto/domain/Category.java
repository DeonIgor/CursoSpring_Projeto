package com.cursoSpring.projeto.domain;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
  private Integer id;
  private String name;

  public Category() {}

  public Category(Integer id, String name) {
    super();
    this.id = id;
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Category)) {
      return false;
    }
    Category category = (Category) o;
    return (
      Objects.equals(id, category.id) && Objects.equals(name, category.name)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
