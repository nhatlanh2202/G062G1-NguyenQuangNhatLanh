import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../services/product.service";
import {MatDialog} from "@angular/material/dialog";
import {ProductCreateComponent} from "../product-create/product-create.component";
import {ProductEditComponent} from "../product-edit/product-edit.component";
import {ProductDeleteComponent} from "../product-delete/product-delete.component";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public productList;
  public term: any;
  public p: any;
  public key ='id';
  public reverse = false;


  constructor(
    public productService: ProductService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.productService.getAllProduct().subscribe(data => {
      this.productList = data
    })
  }

  openAddNew() {
    const dialogRef = this.dialog.open(ProductCreateComponent, {
      width: '850px',
      height: '550px',
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.ngOnInit();
    });
  }

  openDialogEdit(productId) {
    this.productService.getProductById(productId).subscribe(dataProduct => {
      const dialogRef = this.dialog.open(ProductEditComponent, {
        width:'800px',
        height: '700px',
        data:{dataP: dataProduct.id},
        disableClose: false
      });
      console.log('data:' + dataProduct.id);
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openDialogDelete(productId) {
    this.productService.getProductById(productId).subscribe(dataProduct => {
      const dialogRef = this.dialog.open(ProductDeleteComponent, {
        width: '550px',
        data: {dataP: dataProduct},
        disableClose: false
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      })
    })
  }

  sort(key) {
    console.log(this.productList);
    this.key = key;
    this.reverse = !this.reverse;
  }
}
