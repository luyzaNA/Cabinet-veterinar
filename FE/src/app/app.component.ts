import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {RegisterComponent} from "./Autentificare/Register/register.component";
import {NavBarComponent} from "./nav-bar/nav-bar.component";
import {ServicesListComponent} from "./MedicalService/services-list/services-list.component";
import {ServiceComponent} from "./MedicalService/service/service.component";
import {HttpClientModule} from "@angular/common/http";
import {CreateAppointmentComponent} from "./Appointment/create-appointment/create-appointment.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RegisterComponent, NavBarComponent, ServicesListComponent, ServiceComponent, HttpClientModule, CreateAppointmentComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cabinet-veterinar';
}
