import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
// import {environment} from "../../../env/environment";
import {Observable} from "rxjs";
import {ProfileId} from "../models/profile";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  // apiUrl = environment.apiUrl

  constructor(private http: HttpClient) {}

  public getAllProfiles(): Observable<ProfileId[]> {
    return this.http.get<ProfileId[]>(`http://localhost:8080/profiles`);
  }
}
