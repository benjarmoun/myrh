import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {jobOffer} from "../models/jobOffer";
import * as http from "http";
// import {environment} from "../../../env/environment";
// import {AuthCredentials} from "../models/auth-credentials";

@Injectable({
  providedIn: 'root'
})
export class JobOfferService {
  // apiUrl = environment.apiUrl

  constructor(private http: HttpClient) {}

  public getAllOffers(token: string): Observable<jobOffer[]> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<jobOffer[]>(`http://localhost:8080/allJobOffers`, {headers});
  }

  public getPendingOffers(token: string): Observable<jobOffer[]> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<jobOffer[]>(`http://localhost:8080/agent/pendingJobOffers`, {headers});
  }
  public agentGetOfferById(token: string, offerId: number): Observable<jobOffer> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    // @ts-ignore
    return this.http.get<jobOffer>(`http://localhost:8080/agent/jobOffer/${offerId}`,{headers});
  }

  public acceptOffer(token: string, offerId: number): Observable<String>{
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    // @ts-ignore
    return this.http.get<String>(`http://localhost:8080/agent/accept/${offerId}`,{headers, responseType: "text"});
  }

  public getAcceptedOffers(): Observable<jobOffer[]> {
    return this.http.get<jobOffer[]>(`http://localhost:8080/jobOffers`);
  }


  // public getCompanyOffers(companyId: number): Observable<jobOffer[]> {
  //   return this.http.get<jobOffer[]>(`${this.apiUrl}/offers/company/${companyId}`);
  // }

  // add token here ......
  // public addJobOffer(offer: jobOffer, companyId: number, token: string): Observable<String> {
  //   offer.companyId = companyId;
  //   // console.log(token);
  //   const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  //   // @ts-ignore
  //   return this.http.post<String>(`${this.apiUrl}/offer-save`, offer, {headers, responseType: "text"});
  // }

  public getOfferById(offerId: number): Observable<jobOffer> {
    return this.http.get<jobOffer>(`http://localhost:8080/jobOffer/${offerId}`);
  }

  public deleteOffer(token: string, offerId: number): Observable<String> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    // @ts-ignore
    return this.http.delete<String>(`${this.apiUrl}/delete-offer/${offerId}`, {headers, responseType: "text"});
  }

}
