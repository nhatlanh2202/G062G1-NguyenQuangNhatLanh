import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  public formCreateNewCustomer: FormGroup;
  public listCustomerType;

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router
  ) { }

  ngOnInit() {
    this.formCreateNewCustomer = this.formBuilder.group({
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

  createNewCustomer() {
      this.customerService.createNewCustomerService(this.formCreateNewCustomer.value).subscribe(data => {
        this.router.navigateByUrl('customer').then(_ => { });
      });
  }
}
