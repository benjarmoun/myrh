import { Component, EventEmitter, Input, Output } from '@angular/core';
import { jobOffer } from 'src/app/models/jobOffer';

@Component({
  selector: 'app-job-offer-card',
  templateUrl: './job-offer-card.component.html',
  styleUrls: ['./job-offer-card.component.css']
})
export class JobOfferCardComponent {
  @Input() jo!: jobOffer
  @Output() viewDetails = new EventEmitter<number>();

  setOfferDetails(offerId: number) {
    this.viewDetails.emit(offerId);
  }
}
