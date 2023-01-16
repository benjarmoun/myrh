import {Component, OnInit, Input} from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  @Input() text!: String;
   isLoged:boolean = false;
   isLogedAg:boolean = false;
  title: String = "hello world";
  constructor(private router: Router) {}
  ngOnInit(){
    if(localStorage.getItem("token") != null){
      this.isLoged = true;
    }
    if(localStorage.getItem("agToken") != null){
      console.log(true)
      this.isLogedAg = true;
    }
  }
  logout(){
    localStorage.removeItem("token");
    this.isLoged = false;
    this.router.navigate(["/"]).then();
  }
  logoutAg(){
    localStorage.removeItem("agToken");
    this.isLogedAg = false;
    this.router.navigate(["/agent/login"]).then();
  }


}
