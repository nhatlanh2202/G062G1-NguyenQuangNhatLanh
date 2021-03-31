import {Component, OnInit} from '@angular/core';
import {IStudent} from "./IStudent";

@Component({
  selector: 'app-student-new',
  templateUrl: './student-new.component.html',
  styleUrls: ['./student-new.component.css']
})
export class StudentNewComponent implements OnInit {
  studentInfor: IStudent[] = [
    {
      id: 1,
      name: 'Lanh',
      age: 18,
      mark: 10
    },
    {
      id: 2,
      name: 'Chau',
      age: 20,
      mark: 9
    }
  ];


  constructor() {
  }

  ngOnInit(): void {
  }
}
