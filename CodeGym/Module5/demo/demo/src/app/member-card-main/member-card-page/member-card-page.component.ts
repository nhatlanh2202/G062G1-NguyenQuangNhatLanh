import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {} from "../../member-card/model/memberCardSearch";
import {MemberCardSearch} from "../model/memberCardSearch";
import {HttpClient} from "@angular/common/http";
import {MatDialog} from "@angular/material/dialog";
import {MemberCardPageService} from "../../services/member-card-page.service";
import {map, tap} from "rxjs/operators";
import {MemberCardCreateComponent} from "../member-card-create/member-card-create.component";

@Component({
  selector: 'app-member-card-page',
  templateUrl: './member-card-page.component.html',
  styleUrls: ['./member-card-page.component.css']
})
export class MemberCardPageComponent implements OnInit {
  private formSearchList: FormGroup;
  memberCard: any = null;
  memberCardPage: Observable<any[]>;
  memberCardList: any[];
  lastPage: number;
  currentPage: number;
  pageSize;
  totalElements: number;
  isEmpty = false;
  stt: number[];
  private message: string;
  private searchFields: MemberCardSearch = {} as MemberCardSearch;

  constructor(private memberCardPageService: MemberCardPageService,
              private httpClient: HttpClient,
              public dialog: MatDialog,
              public formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formSearchList = this.formBuilder.group({
      // tslint:disable-next-line:max-line-length
      fullName: [''],
      plateNumber: [''],
    });
    // this.getMemberCardPage(1);
    this.getAllMemberCard();
  }

  // search() {
  //   this.searchFields = this.formSearchList.value as MemberCardSearch;
  //   this.getMemberCardPage(1);
  // }

  // getMemberCardPage(pageNumber) {
  //   this.memberCardPage = this.memberCardPageService.getMemberCardPage(this.searchFields, pageNumber).pipe(
  //     tap(res => {
  //       console.log(res);
  //       this.totalElements = res.totalElements;
  //       this.pageSize = res.size;
  //       this.currentPage = pageNumber;
  //
  //       this.stt = [];
  //       const firstIndex = this.pageSize * (this.currentPage - 1) + 1;
  //       const lastIndex = this.pageSize * this.currentPage;
  //       for (let i = firstIndex; i <= lastIndex; i++) {
  //         this.stt.push(i);
  //       }
  //
  //       this.isEmpty = false;
  //       if (res.content.length === 0) {
  //         this.isEmpty = true;
  //       }
  //     }, error => {
  //       console.log(error);
  //       console.log('vào được err của tap');
  //     }),
  //     map(res => res.content)
  //   );
  // }

  getAllMemberCard(): void {
    this.memberCardPageService.getMemberCardList().subscribe(data => {
      this.memberCardList = data;
      console.log(data);
    });
  }

  openAddNew() {
    const dialogRef = this.dialog.open(MemberCardCreateComponent, {
      width: '850px',
      height: '550px',
      disableClose: false
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    })
  }
}
