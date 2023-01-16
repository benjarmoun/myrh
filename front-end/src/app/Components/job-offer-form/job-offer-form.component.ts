import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProfileId } from 'src/app/models/profile';
import { ProfileService } from 'src/app/services/profile.service';
import {HttpErrorResponse} from "@angular/common/http";
import { Router } from '@angular/router';


@Component({
  selector: 'app-job-offer-form',
  templateUrl: './job-offer-form.component.html',
  styleUrls: ['./job-offer-form.component.css']
})
export class JobOfferFormComponent {
  title!: string;
  description!: string;
  profileId!: number;
  city!: string;
  degree!: string;
  salary!: number;

  profiles!: ProfileId[]


  constructor(private http: HttpClient, private profileService: ProfileService, private router: Router) {}

  ngOnInit() {
    if(localStorage.getItem("token") == null){
      this.router.navigate(["/login"]).then();
    }else
    this.fetchAllProfiles();
  }

  jobOffer() {
    console.log(this.profileId)
    const token = localStorage.getItem('token');

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    const formData = {
      title: this.title,
      description: this.description,
      profileId: this.profileId,
      city: this.city,
      degree: this.degree,
      salary: this.salary,


    };

    this.http.post('http://localhost:8080/rh/addJobOffer', formData,{headers: headers}).subscribe(
      response =>{
        // @ts-ignore
        console.log(response['status'])
      }
    );
  }




  fetchAllProfiles() {
    this.profileService.getAllProfiles().subscribe(
      (res: ProfileId[]) => {
        this.profiles = res;
      }, (error: HttpErrorResponse) => {
        console.log(error.message)
      }
    )
  }
}
