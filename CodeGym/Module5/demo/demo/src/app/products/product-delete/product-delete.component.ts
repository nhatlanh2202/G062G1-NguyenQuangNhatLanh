import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  public nameP;
  public id;

  constructor(
    public dialogRef: MatDialogRef<ProductDeleteComponent>,
    public productService: ProductService,
    public router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    this.nameP = this.data.dataP.soXe;
    this.id = this.data.dataP.id;
    console.log(this.id);
  }

  deleteProduct() {
    this.productService.deleteProduct(this.id).subscribe(data => {
      this.router.navigateByUrl('').then(_ => { });
      this.dialogRef.close();
    });
  }

}
