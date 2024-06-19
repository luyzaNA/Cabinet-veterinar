package ro.ZYMinds.entitity;


import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class MedicalOperation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Long version;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Embedded
  private CurrencyValue price;

  public MedicalOperation() {

  }

  public MedicalOperation(String name, CurrencyValue price) {
    this.name = name;
    this.price = price;
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

  public CurrencyValue getPrice() {
    return price;
  }

  public void setPrice(CurrencyValue price) {
    this.price = price;
  }

  public boolean isTransient() {
    return version == null;
  }
}
