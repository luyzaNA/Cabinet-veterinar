import {Component} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatStepperModule} from '@angular/material/stepper';
import { MedicalOperationService } from '../../Service/MedicalOperation.service';
import {Currency, CurrencyValue, MedicalOperationI} from "../../../Shared/MedicalOperation.entity";
import {NgIf} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-service',
  standalone: true,
  imports: [MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule, NgIf, HttpClientModule],
  templateUrl: './service.component.html',
  styleUrl: './service.component.css'
})
export class ServiceComponent {
  firstCtrl: string = '';
  secondCtrl!: number;
  moneda!: Currency;

  constructor(private medicalOperationService: MedicalOperationService) {}

  saveMedicalOperation() {
    const name = this.firstCtrl;
    const price: CurrencyValue = {
      currency: this.moneda,
      value: this.secondCtrl
    };

    this.medicalOperationService.createMedicalOperation(name, price)
      .subscribe((result: MedicalOperationI) => {
        console.log('Medical operation saved successfully', result);
        alert("Salvarea s a efectuat cu succes")
        this.resetFields();
      }, error => {
        console.error('Error saving medical operation', error);
        alert(" Eroare la salvarea serviciului medical")
      });
  }

  resetFields() {
    this.firstCtrl = '';
    this.secondCtrl = 0;
    this.moneda = Currency.RON;
  }
}
