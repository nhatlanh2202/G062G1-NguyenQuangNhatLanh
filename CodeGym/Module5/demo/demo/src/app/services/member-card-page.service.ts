import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MemberCardSearch} from "../member-card-main/model/memberCardSearch";
import {Observable} from "rxjs";
import {Page} from "../member-card-main/model/page";

@Injectable({
  providedIn: 'root'
})
export class MemberCardPageService {
  // private readonly API = 'http://localhost:8080/dto';
  private readonly API = 'http://localhost:8080/api';


  private options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
    // responseType: 'text' as 'json'
  };

  constructor(private http: HttpClient) { }

  // getMemberCardHttpOptions(searchField: MemberCardSearch, page: number): Object {
  //   const memberCard = {
  //     headers: new HttpHeaders({
  //       'Content-Type': 'application/json'
  //     }),
  //     params: {
  //       fullName: searchField.fullName,
  //       plateNumber: searchField.plateNumber,
  //       page
  //     }
  //   };
  //   return memberCard;
  // }

  // getMemberCardPage(searchField: MemberCardSearch, page: number): Observable<Page<any>> {
  //   return this.http.get<Page<any>>(`${this.API}/member-card/page`, this.getMemberCardHttpOptions(searchField, page));
  // }

  // getMemberCardList(): Observable<any[]> {
  //   return this.http.get<any[]>(`${this.API}/member-card/list`, this.options);
  // }

  getMemberCardList(): Observable<any[]> {
    return this.http.get<any[]>(`${this.API}/list`, this.options);
  }

  createNewMemberCard(): Observable<any> {
    return this.http.post(`${this.API}/member-cards`, this.options);
  }
}
