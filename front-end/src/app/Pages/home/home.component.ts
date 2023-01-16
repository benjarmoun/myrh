import { Component, OnInit } from '@angular/core';
import {jobOffer} from "../../models/jobOffer";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import { JobOfferService } from 'src/app/services/jobOffer.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  jobOffers!: jobOffer[];
  viewOffer!: jobOffer;


  constructor(private offerService: JobOfferService) {
  }

  ngOnInit(): void {
    this.fetchAllOffers();
    // console.log( this.jobOffers);
  }

  fetchAllOffers() {
    this.offerService.getAcceptedOffers().subscribe(
      (res: jobOffer[]) => {
        this.jobOffers = res;
        this.viewOffer = res[0];
        console.log(this.jobOffers)
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }

  viewOfferDetails(offerId: number){
    this.offerService.getOfferById(offerId).subscribe(
      (res: jobOffer) => {
        // @ts-ignore
        this.viewOffer = res[0];
        console.log(this.viewOffer)
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }
}
