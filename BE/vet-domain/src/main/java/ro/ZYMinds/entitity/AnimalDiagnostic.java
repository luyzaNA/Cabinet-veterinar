package ro.ZYMinds.entitity;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostics")
public class AnimalDiagnostic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "description", length = 50)
  private String description;

  @Version
  private Long version;

  public AnimalDiagnostic() {
  }

  public AnimalDiagnostic(String name, String description) {
    this.name = name;
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isTransient() {
    return version == null;
  }
}
