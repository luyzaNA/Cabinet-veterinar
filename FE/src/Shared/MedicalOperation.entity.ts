export enum Currency {
  RON = 'RON',
  EUR = 'EUR',
  USD = 'USD'
}
export interface CurrencyValue {
  currency: Currency;
  value: number;
}
export interface MedicalOperationI {

  id: string;
  name: string;
  price: CurrencyValue;
}

export class MedicalOperation implements MedicalOperationI {
  id: string;
  name: string;
  price: CurrencyValue;

  constructor(id: string, name: string, price: CurrencyValue) {
    this.id = id;
    this.name = name;
    this.price = price;
  }
}

