import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from "../student-new/IStudent";
import {studentDao} from "../student-new/ListStudent";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  studentAdd: IStudent;
  studentList = studentDao;

  @Input() studentCreate: IStudent;
  // @Output()
  // addNewStudent: EventEmitter<IStudent> = new EventEmitter<IStudent>();


  constructor() { }

  ngOnInit(): void {
  }

  createNewStudent(id: string, name: string, age: string, mark: string) {
    this.studentAdd = {
      id: Number(id),
      name: name,
      age: Number(age),
      mark: Number(mark)
    };
    this.studentList.push(this.studentAdd)
  }
}
