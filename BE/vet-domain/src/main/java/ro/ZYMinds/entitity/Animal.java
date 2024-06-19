package ro.ZYMinds.entitity;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Long version;


  @Column(name = "name", length = 50, nullable = false)
  private String name;

  public Animal() {
  }

  public Animal(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isTransient() {
    return version == null;
  }
}
