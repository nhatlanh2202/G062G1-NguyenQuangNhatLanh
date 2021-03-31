import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from "../student-new/IStudent";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input()
  studentChild: IStudent;
  @Output()
  markOutput: EventEmitter<number> = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  getInputMark(value: number) {
    this.markOutput.emit(value);
    this.studentChild.mark = value;
  }
}
