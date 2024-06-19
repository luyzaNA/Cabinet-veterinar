import { Routes } from '@angular/router';
import {RegisterComponent} from "./Autentificare/Register/register.component";
import {LoginComponent} from "./Autentificare/Login/login.component";
import {FirstPageComponent} from "./first-page/first-page.component";

export const routes: Routes = [
  {
    path:'register', component: RegisterComponent
  },
  {
    path:'login', component: LoginComponent
  },
  {
    path:'first-page', component: FirstPageComponent
  }
];
