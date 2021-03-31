import {Component, OnInit} from '@angular/core';
import {FeedbackContentDialogComponent} from '../feedback-content-dialog/feedback-content-dialog.component';
import {MatDialog} from '@angular/material/dialog';
import {Feedback} from "../shared/model/feedback";
import {FeedbackService} from "../shared/service/feedback.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {FeedbackSearch} from "../shared/model/feedbackSearch";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";



@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent implements OnInit {
  private formSearchList: FormGroup;
  feedback: Feedback = null;
  feedbackPage;
  feedbackList: Feedback[];
  lastPage: number;
  currentPage: number;
  pageSize: number;
  totalElements: number;
  isEmpty = false;
  stt: number[];
  unprocessedStatusAmount = 0;
  private message: string;
  private searchFields: FeedbackSearch = {} as FeedbackSearch;




  constructor(private feedbackService: FeedbackService,
              private httpClient: HttpClient,
              public dialog: MatDialog,
              public formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formSearchList = this.formBuilder.group({
      senderName: [''],
      sendDate: [''],
      processStatus: [''],
    });
    this.getFeedbackPage();
    this.getAllFeedback();
  }

  search() {
    this.searchFields = this.formSearchList.value as FeedbackSearch;
    console.log(this.searchFields.sendDate);
    this.getFeedbackPage();
  }

  getFeedbackPage() {
    this.feedbackPage = this.feedbackService.getFeedbackPage(this.searchFields).pipe(
      tap(res => {
        console.log(res);
        this.stt = [];
        const firstIndex = this.pageSize * (this.currentPage - 1) + 1;
        const lastIndex = this.pageSize * this.currentPage;
        for (let i = firstIndex; i <= lastIndex; i++) {
          this.stt.push(i);
        }

        this.isEmpty = false;
        if (res.content.length === 0) {
          this.isEmpty = true;
        }
      }, error => {
        console.log(error);
        console.log('vào được err của tap');
      }),
      map(res => res.content)
    );
  }

  getAllFeedback(): void {
    this.feedbackService.getFeedbackList().subscribe(data => {
      this.feedbackList = data;
      for (let i = 0; i < this.feedbackList.length; i++) {
        if (this.feedbackList[i].processStatus === false) {
          this.unprocessedStatusAmount++;
        }
      }
    });
  }

  openFeedbackDialog(feedback): void {
    this.feedback = feedback;
    const dialogRef = this.dialog.open(FeedbackContentDialogComponent, {
      width: '700px',
      data: {data1: this.feedback},
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(this.feedback);
      this.feedbackService.editFeedback(this.feedback, this.feedback.id).subscribe();
      this.ngOnInit();
    });
  }

  setColorFieldStatusOfProcessStatus(status) {
    if (status === false) {
      return 'text-danger';
    } else if (status === true) {
      return 'text-muted';
    }
  }
}


