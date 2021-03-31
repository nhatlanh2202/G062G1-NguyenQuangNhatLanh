import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FeedbackSearch} from "../feedback/model/feedbackSearch";
import {Observable} from "rxjs";
import {Feedback} from "../feedback/model/feedback";
import {Page} from "../feedback/model/page";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private readonly API = 'http://localhost:8080/feedback';

  constructor(private http: HttpClient) { }

  private options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
    // responseType: 'text' as 'json'
  };


  getFeedbackHttpOptions(searchField: FeedbackSearch, page: number): Object {
    const feedback = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      params: {
        senderName: searchField.senderName,
        sendDate: searchField.sendDate,
        processStatus: searchField.processStatus,
        page
      }
    };
    return feedback;
  }

  // getFeedbackPage(searchField: FeedbackSearch): Observable<Feedback> {
  //   return this.http.get<Feedback>(`${this.API}/feedback-page`, this.getFeedbackHttpOptions(searchField));
  // }

  getFeedbackPage(searchField: FeedbackSearch, page: number): Observable<Page<Feedback>> {
    return this.http.get<Page<Feedback>>(`${this.API}/feedback-page` , this.getFeedbackHttpOptions(searchField, page));
  }

  getFeedbackList(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.API}/feedback-list`, this.options);
  }

  editFeedback(feedback, id): Observable<Feedback> {
    console.log(`${this.API}/feedback-send` + '/' + id);
    console.log(feedback);
    return this.http.put<Feedback>(`${this.API}/feedback-send` + '/' + id, feedback);
  }
}
