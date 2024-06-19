package ro.ZYMinds.entitity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class CurrencyValue {

  @Column(name = "price_currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;

  @Column(name = "price_value")
  private Double value;

  public CurrencyValue() {
  }

  public CurrencyValue(Currency currency, Double value) {
    this.currency = currency;
    this.value = value;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }
}
