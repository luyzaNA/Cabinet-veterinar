import { Routes } from '@angular/router';
import {RegisterComponent} from "./Autentificare/Register/register.component";
import {LoginComponent} from "./Autentificare/Login/login.component";

export const routes: Routes = [
  {
    path:'register', component: RegisterComponent
  },
  {
    path:'login', component: LoginComponent
  }
];
