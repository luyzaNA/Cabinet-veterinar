package ro.ZYMinds.dto;

import ro.ZYMinds.entitity.CurrencyValue;

public class MedicalOperationDto {

  private Long id;
  private String name;
  private CurrencyValue price;

  public MedicalOperationDto() {

  }

  public MedicalOperationDto(Long id, String name, CurrencyValue price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
