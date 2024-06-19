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
  medicalOperationId: string;
  medicalOperationName: string;
  medicalOperationPrice: CurrencyValue;
}

export class MedicalOperation implements MedicalOperationI {
  medicalOperationId: string;
  medicalOperationName: string;
  medicalOperationPrice: CurrencyValue;

  constructor(medicalOperationId: string, medicalOperationName: string, medicalOperationPrice: CurrencyValue) {
    this.medicalOperationId = medicalOperationId;
    this.medicalOperationName = medicalOperationName;
    this.medicalOperationPrice = medicalOperationPrice;
  }
}
