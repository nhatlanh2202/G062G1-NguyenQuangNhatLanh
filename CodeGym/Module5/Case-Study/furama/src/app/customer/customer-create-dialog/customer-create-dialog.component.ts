import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer/customer.service';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-customer-edit-dialog',
  templateUrl: './customer-create-dialog.component.html',
  styleUrls: ['./customer-create-dialog.component.css']
})
export class CustomerCreateDialogComponent implements OnInit {
  formAddDialog: FormGroup;
  public listCustomerType;

  constructor(
    private fb: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public dialogRef: MatDialogRef<CustomerCreateDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.formAddDialog = this.fb.group({
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
  }

  addNewCustomerDialog() {
    this.customerService.createNewCustomerService(this.formAddDialog.value).subscribe(data => {
      // console.log(this.formAddDialog.value);
      // this.router.navigateByUrl('customer').then(_ => {});
      this.dialogRef.close();
    });
  }
}
