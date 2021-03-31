import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FeedbackService} from "../shared/service/feedback.service";

@Component({
  selector: 'app-feedback-content-dialog',
  templateUrl: './feedback-content-dialog.component.html',
  styleUrls: ['./feedback-content-dialog.component.css']
})
export class FeedbackContentDialogComponent implements OnInit {
  public senderName;
  public senderEmail;
  public title;
  public content;
  public sendDate;
  public status;
  public responseContent;
  sendMailForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<FeedbackContentDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public feedbackService: FeedbackService
  ) {}

  ngOnInit() {
    this.sendMailForm = new FormGroup({
      responseContent: new FormControl(''),
    });
    this.senderName = this.data.data1.senderName;
    this.senderEmail = this.data.data1.senderEmail;
    this.title = this.data.data1.title;
    this.content = this.data.data1.content;
    this.sendDate = this.data.data1.sendDate;
    this.status = this.data.data1.status;
    this.data.data1.responseContent = this.sendMailForm.value.responseContent;
    console.log(this.responseContent);
  }
  check() {
    this.data.data1.responseContent = this.responseContent;
  }
}
