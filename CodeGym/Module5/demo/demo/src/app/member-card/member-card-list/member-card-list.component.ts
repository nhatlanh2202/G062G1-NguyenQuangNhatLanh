import {Component, OnInit} from '@angular/core';
import {MemberCardService} from "../../services/member-card.service";



@Component({
  selector: 'app-member-card-list',
  templateUrl: './member-card-list.component.html',
  styleUrls: ['./member-card-list.component.css']
})
export class MemberCardListComponent implements OnInit {
  memberCardList = [];



  constructor(private memberCardService: MemberCardService) {
  }

  ngOnInit() {
    this.memberCardService.getAllMemberCard().subscribe(data => {
      this.memberCardList = data
    })
  }

}
