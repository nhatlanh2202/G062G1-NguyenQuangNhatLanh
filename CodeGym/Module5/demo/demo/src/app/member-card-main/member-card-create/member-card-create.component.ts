import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MemberCardPageService} from "../../services/member-card-page.service";

@Component({
  selector: 'app-member-card-create',
  templateUrl: './member-card-create.component.html',
  styleUrls: ['./member-card-create.component.css']
})
export class MemberCardCreateComponent implements OnInit {
  formAddDialog: FormGroup;

  constructor(private formBuilder: FormBuilder,
              public memberCardPageService: MemberCardPageService,
              public router: Router,
              public dialogRef: MatDialogRef<MemberCardCreateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit(): void {
    this.formAddDialog = this.formBuilder.group({
      plateNumber: ['', [Validators.required, Validators.pattern('^(43A-){4}$')]],
      fullName: [''],
      memberTypeID: [''],
      startDate: [''],
      endDate: [''],
      slotNumber: [''],
      price: [''],
    });
    this.memberCardPageService
  }

}
