import {Component, ViewChild} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {FormsModule, NgForm} from "@angular/forms";
import {MatButton, MatIconButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {MatInput} from "@angular/material/input";
import {NavBarComponent} from "../../nav-bar/nav-bar.component";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatIcon,
    MatLabel,
    MatFormField,
    FormsModule,
    MatButton,
    RouterLink,
    MatIconButton,
    MatInput,
    MatSuffix,
    NavBarComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  @ViewChild('loginForm') loginForm!: NgForm;
  hide = true;

  clickEvent(event: MouseEvent) {
    this.hide = !this.hide;
    event.stopPropagation();
  }

  onLogin(email: string, password: string) {
    console.log(email, password);
    alert("Logarea s a efectuat cu succes");
    this.loginForm.resetForm();
  }
}
