import {Component, OnInit} from '@angular/core';
import {IStudent} from './IStudent';
import {studentDao} from './ListStudent';

@Component({
  selector: 'app-student-new',
  templateUrl: './student-new.component.html',
  styleUrls: ['./student-new.component.css']
})
export class StudentNewComponent implements OnInit {
  studentList = studentDao;
  studentDetail: IStudent;
  studentCreate: IStudent;
  constructor() {
  }

  ngOnInit(): void {
  }

  showDetail(value) {
    this.studentDetail = value;
  }

  showCreate() {
    // tslint:disable-next-line:new-parens
    this.studentCreate = new class implements IStudent {
      age: number;
      id: number;
      mark: number;
      name: string;
    };
  }
}
