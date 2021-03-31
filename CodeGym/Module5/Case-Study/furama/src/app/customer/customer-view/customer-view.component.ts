import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer/customer.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-customer-view',
  templateUrl: './customer-view.component.html',
  styleUrls: ['./customer-view.component.css']
})
export class CustomerViewComponent implements OnInit {
  public dataCustomer;


  constructor(
    private formBuilder: FormBuilder,
    public router: Router,
    public dialogRef: MatDialogRef<CustomerViewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
  }

  ngOnInit() {
    this.dataCustomer = {
      idCus: this.data.dataView.idCus,
      name: this.data.dataView.name,
      birthDay: this.data.dataView.birthDay,
      idCard: this.data.dataView.idCard,
      phone: this.data.dataView.phone,
      address: this.data.dataView.address,
      email: this.data.dataView.email,
      customerType: this.data.dataView.customerType,
    };
  }
}
