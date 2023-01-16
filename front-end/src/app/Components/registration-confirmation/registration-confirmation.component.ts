import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-confirmation',
  templateUrl: './registration-confirmation.component.html',
  styleUrls: ['./registration-confirmation.component.css']
})
export class RegistrationConfirmationComponent {
  code!: number;

  constructor(private http: HttpClient, private router: Router) {}

  confirm() {


    const formData = {
      verCode: this.code
    };

    this.http.post('http://localhost:8080/code-verification', formData).subscribe(
    );
    this.router.navigate(['/login']);
  }
}
