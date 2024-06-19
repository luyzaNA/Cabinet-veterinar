package ro.ZYMinds.entitity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Long version;


  @Column(name = "name", length = 50, nullable = false)
  private String name;

  public Doctor() {

  }

  public Doctor(String name) {

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
