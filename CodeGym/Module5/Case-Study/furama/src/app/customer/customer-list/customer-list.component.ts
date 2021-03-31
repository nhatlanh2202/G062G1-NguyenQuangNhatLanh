import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer/customer.service';
import {MatDialog} from '@angular/material';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {CustomerEditComponent} from '../customer-edit/customer-edit.component';
import {CustomerCreateDialogComponent} from '../customer-create-dialog/customer-create-dialog.component';
import {CustomerViewComponent} from '../customer-view/customer-view.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customerList;
  public term: any;
  public p: any;

  constructor(
    public customerService: CustomerService,
    public dialog: MatDialog
    ) { }

  ngOnInit() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customerList = data;
    });
  }

  openDialogDelete(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '550px',
        data: {dataC: dataCustomer},
        disableClose: false
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });

  }

  openDialogEdit(customerId) {
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerEditComponent, {
        width: '800px',
        height: '700px',
        data: {dataC: dataCustomer.id},
        disableClose: false
      });
      console.log('data:' + dataCustomer.id);
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openAddNew() {
    const dialogRef = this.dialog.open(CustomerCreateDialogComponent, {
      width: '830px',
      height: '550px',
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });
  }

  openDialogView(id: any) {
    this.customerService.findById(id).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerViewComponent, {
        width: '400px',
        height: '500px',
        data: {dataView: dataCustomer},
        disableClose: false
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}
