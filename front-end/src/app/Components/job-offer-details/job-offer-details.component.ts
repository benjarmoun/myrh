import { Component, Input, OnInit, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { jobOffer } from 'src/app/models/jobOffer';
import { JobOfferService } from 'src/app/services/jobOffer.service';

@Component({
  selector: 'app-job-offer-details',
  templateUrl: './job-offer-details.component.html',
  styleUrls: ['./job-offer-details.component.css']
})
export class JobOfferDetailsComponent implements OnInit{
  @Input() isAgent: boolean = false;
  @Input() viewJo!: jobOffer


  constructor(private offerService: JobOfferService,
              private router: Router,
              private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    if(localStorage.getItem("agToken") != null){
      this.isAgent = true;
    }
    // console.log(this.viewJo.profileId.id);
  }

  func(){
    console.log(this.viewJo);
  }
  acceptJobOffer(id: number){
    // @ts-ignore
    this.offerService.acceptOffer(localStorage.getItem("agToken"),id).subscribe();
    

  }

}
