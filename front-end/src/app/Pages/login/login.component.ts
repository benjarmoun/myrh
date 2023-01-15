import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email!: string;
  password!: string;

  constructor(private http: HttpClient,
              private router: Router) {}
  login() {
    console.log(this.email)
    console.log(this.password)

    const formData = {
      "email": "email",
      "password": "password"
    };

    this.http.post('http://localhost:8080/auth/rh', formData)
      .subscribe(response => {
        console.log(response)
      // @ts-ignore
        const token = response['token'];
      localStorage.setItem('token', token);
        this.router.navigate(['/form']);
    });
  }

}
