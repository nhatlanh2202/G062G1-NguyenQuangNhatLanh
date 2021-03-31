import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MemberCardSearch} from "../member-card/model/memberCardSearch";
import {Observable} from "rxjs";
import {Page} from "../member-card/model/page";

@Injectable({
  providedIn: 'root'
})
export class MemberCardService {
  private readonly API = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getAllMemberCard(): Observable<any> {
    return this.http.get(this.API + '/member-card')
  }

}
