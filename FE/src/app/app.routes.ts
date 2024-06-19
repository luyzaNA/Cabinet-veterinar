import { Routes } from '@angular/router';
import {RegisterComponent} from "./Autentificare/Register/register.component";
import {LoginComponent} from "./Autentificare/Login/login.component";
import {FirstPageComponent} from "./first-page/first-page.component";
import {ServiceComponent} from "./MedicalService/service/service.component";
import {ServicesListComponent} from "./MedicalService/services-list/services-list.component";
import {CreateAppointmentComponent} from "./Appointment/create-appointment/create-appointment.component";

export const routes: Routes = [
  {
    path:'register', component: RegisterComponent
  },
  {
    path:'login', component: LoginComponent
  },
  {
    path:'first-page', component: FirstPageComponent
  },
  {
    path:'services', component: ServiceComponent
  },
  {
    path:'services-list', component: ServicesListComponent
  },
  {
    path: "appointment", component: CreateAppointmentComponent
  }
];
