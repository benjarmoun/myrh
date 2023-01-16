import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userName!: string;
  email!: string;
  password!: number;
  address!: string;
  companyName!: string;
  phoneNum!: number;

  constructor(private http: HttpClient, private router: Router) {}

  register() {
    console.log(this.password)
    // const token = localStorage.getItem('token');


    const formData = {
      userName: this.userName,
      email: this.email,
      password: this.password,
      address: this.address,
      companyName: this.companyName,
      phoneNum: this.phoneNum,
      imageUrl: "imageUrl"


    };
    console.log(formData)
    this.http.post('http://localhost:8080/register', formData).subscribe();
    this.router.navigate(['/confirm']);
  }
}
