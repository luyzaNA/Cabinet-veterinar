import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {ContactComponent} from "./contact/contact.component";

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  standalone: true,
  imports: [
    FormsModule,
    ContactComponent
  ],
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent {



}
