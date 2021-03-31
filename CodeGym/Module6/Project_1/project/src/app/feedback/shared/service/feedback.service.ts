import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FeedbackSearch} from "../model/feedbackSearch";
import {Observable} from "rxjs";
import {Page} from "../model/dto/page";
import {Feedback} from "../model/feedback";



@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private readonly API = 'http://localhost:8080/api/v1/admin';


  private options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
    // responseType: 'text' as 'json'
  };

  constructor(private http: HttpClient) { }

  getFeedbackHttpOptions(searchField: FeedbackSearch): Object {
    const feedback = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      params: {
        senderName: searchField.senderName,
        sendDate: searchField.sendDate,
        processStatus: searchField.processStatus
      }
    };
    return feedback;
  }

  getFeedbackPage(searchField: FeedbackSearch): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.API}/feedback-page`, this.getFeedbackHttpOptions(searchField));
  }

  getFeedbackList(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.API}/feedback-list`, this.options);
  }

  editFeedback(feedback, id): Observable<Feedback> {
    console.log(`${this.API}/feedback` + '/' + id);
    console.log(feedback);
    return this.http.put<Feedback>(`${this.API}/feedback` + '/' + id, feedback);
  }
}
