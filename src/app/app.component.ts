import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {RegisterComponent} from "./Autentificare/Register/register.component";
import {NavBarComponent} from "./nav-bar/nav-bar.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RegisterComponent, NavBarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cabinet-veterinar';
}
