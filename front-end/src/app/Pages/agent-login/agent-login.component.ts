import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agent-login',
  templateUrl: './agent-login.component.html',
  styleUrls: ['./agent-login.component.css']
})
export class AgentLoginComponent {

  email!: string;
  password!: string;

  constructor(private http: HttpClient,
              private router: Router) {}

  ngOnInit(): void {
    if(localStorage.getItem("agToken") != null){
      this.router.navigate(["/agent/dash"]).then();
    }
  }
  loginAgent() {

    const formData = {
      "email": this.email,
      "password": this.password
    };

    this.http.post('http://localhost:8080/auth/agent', formData)
      .subscribe(response => {
        console.log(response)
        // @ts-ignore
        const token = response['token'];
        localStorage.setItem('agToken', token);
        this.router.navigate(['/agent/dash']);
      });
  }

}
