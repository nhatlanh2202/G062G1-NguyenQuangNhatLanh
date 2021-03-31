import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer/customer.service';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  formEditCustomer: FormGroup;
  public listCustomerType;
  public dataId;


  constructor(
    private formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public dialogRef: MatDialogRef<CustomerEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit() {
    this.formEditCustomer = this.formBuilder.group({
      idCus: ['', [Validators.required, Validators.pattern('(KH-)[0-9]{4}')]],
      name: ['', [Validators.required]],
      birthDay: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^(([0-9]{12})|([0-9]{9}))$')]],
      phone: ['', [Validators.required, Validators.pattern('^(090|091|(84)+90|(84)+91)\\d{7}$')]],
      address: [''],
      email: ['', [Validators.required, Validators.email]],
      customerType: ['Diamond'],
    });
    this.customerService.getAllTypeCustomer().subscribe(data => {
      this.listCustomerType = data;
    });
    this.dataId = this.data.dataC;
    this.customerService.getCustomerById(this.dataId).subscribe(getData => {
      this.formEditCustomer.patchValue(getData);
    });
  }

  editCustomer() {
    this.customerService.editCustomer(this.formEditCustomer.value, this.dataId).subscribe(data => {
      this.router.navigateByUrl('customer').then(_ => {
      });
      this.dialogRef.close();
    });
  }
}
