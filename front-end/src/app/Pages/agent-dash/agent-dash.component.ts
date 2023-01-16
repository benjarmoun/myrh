import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { jobOffer } from 'src/app/models/jobOffer';
import { JobOfferService } from 'src/app/services/jobOffer.service';

@Component({
  selector: 'app-agent-dash',
  templateUrl: './agent-dash.component.html',
  styleUrls: ['./agent-dash.component.css']
})
export class AgentDashComponent {

  jobOffers!: jobOffer[];
  viewOffer!: jobOffer;


  constructor(private offerService: JobOfferService, private router:Router) {
  }

  ngOnInit(): void {
    if(localStorage.getItem("agToken") == null){
      this.router.navigate(["/agent/login"]).then();
    }else 
    this.fetchAllOffers();
  }

  fetchAllOffers() {
    // @ts-ignore
    this.offerService.getPendingOffers(localStorage.getItem("agToken")).subscribe(
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
    console.log(offerId)
    // @ts-ignore
    this.offerService.agentGetOfferById(localStorage.getItem("agToken") ,offerId).subscribe(
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
