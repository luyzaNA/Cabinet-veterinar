import {Component, ViewChild} from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, NgForm} from "@angular/forms";
import {RouterLink} from "@angular/router";
import {NavBarComponent} from "../../nav-bar/nav-bar.component";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatButtonModule, MatIconModule, FormsModule, RouterLink, NavBarComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  @ViewChild('singUpForm') signUpForm!: NgForm;

  hide = true;

  clickEvent(event: MouseEvent) {
    this.hide = !this.hide;
    event.stopPropagation();
  }

  onSubmit(name: String, email: String, password: String) {
    alert("Inregistrarea a fost facuta cu succes")
    this.signUpForm.resetForm();
  }

  switchToLogin() {
  }
}
