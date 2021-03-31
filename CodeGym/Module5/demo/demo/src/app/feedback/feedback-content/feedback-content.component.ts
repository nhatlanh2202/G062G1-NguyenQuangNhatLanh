import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormControl, FormGroup} from "@angular/forms";
import {FeedbackService} from "../../services/feedback.service";
import {Feedback} from "../model/feedback";

@Component({
  selector: 'app-feedback-content',
  templateUrl: './feedback-content.component.html',
  styleUrls: ['./feedback-content.component.css']
})
export class FeedbackContentComponent implements OnInit {
  public id;
  feedback: Feedback = null;
  public title;
  public sendDate;
  public senderEmail;
  public senderName;
  public processStatus;
  public content;
  // public responseContent;
  sendMailForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<FeedbackContentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public feedbackService: FeedbackService
  ) { }

  ngOnInit() {
    this.sendMailForm = new FormGroup({
      responseContent: new FormControl(''),
    });

    this.title = this.data.data1.title;
    this.sendDate = this.data.data1.sendDate;
    this.senderEmail = this.data.data1.senderEmail;
    this.senderName = this.data.data1.senderName;
    this.content = this.data.data1.content;
    this.processStatus = this.data.data1.processStatus;
    // this.data.data1.responseContent = this.sendMailForm.value.responseContent;
    // console.log(this.responseContent);
  }

  check() {
    // this.data.data1.responseContent = this.responseContent;
    this.feedbackService.editFeedback(this.feedback, this.feedback.id).subscribe();
  }

}
