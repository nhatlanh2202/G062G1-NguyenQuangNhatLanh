import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {CustomerService} from '../../services/customer/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  public nameCustomer;
  public idCustomer;

  constructor(
    public dialogRef: MatDialogRef<CustomerDeleteComponent>,
    public customerService: CustomerService,
    public router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    this.nameCustomer = this.data.dataC.name;
    this.idCustomer = this.data.dataC.id;
    console.log(this.idCustomer);
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.idCustomer).subscribe(data => {
      this.router.navigateByUrl('customer').then(_ => { });
      this.dialogRef.close();
      }
    );
  }
}
