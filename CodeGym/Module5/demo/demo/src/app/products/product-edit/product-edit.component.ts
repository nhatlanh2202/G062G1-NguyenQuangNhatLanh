import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  formEditProduct: FormGroup;
  public listCategory;
  public dataId;


  constructor(
    private formBuilder: FormBuilder,
    public productService: ProductService,
    public router: Router,
    public dialogRef: MatDialogRef<ProductEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit() {
    this.formEditProduct = this.formBuilder.group({
      // codeProduct: ['',[Validators.required, Validators.pattern('(SP-)[0-9]{4}')]],
      // nameProduct:['',[Validators.required]],
      // producer:['',[Validators.required]],
      // category:['Smart phone'],
      soXe:['',[Validators.required]],
      tenNhaXe:['',[Validators.required]],
      diemDi:['',[Validators.required]],
      diemDen:['',[Validators.required]],
      soDienThoai:['',[Validators.required, Validators.pattern('^(090|093|097|(84)+91)\\d{7}$')]],
      email:['',[Validators.required, Validators.email]],
      gioDi:['',[Validators.required]],
      gioDen:['',[Validators.required]],
      loaiXe:['Giường nằm'],
    });
    this.productService.getAllCategory().subscribe(data => {
      this.listCategory = data;
    });
    this.dataId = this.data.dataP;
    this.productService.getProductById(this.dataId).subscribe(getData => {
      this.formEditProduct.patchValue(getData);
    });
  }

  editProductDialog() {
    this.productService.editProduct(this.formEditProduct.value, this.dataId).subscribe(data => {
      this.router.navigateByUrl('').then(_ => {
      });
      this.dialogRef.close();
    })
  }
}
