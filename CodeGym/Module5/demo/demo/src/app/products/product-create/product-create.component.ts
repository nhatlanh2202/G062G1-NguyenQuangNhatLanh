import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  formAddDialog: FormGroup;
  public listCategory;

  constructor(
    private formBuilder: FormBuilder,
    public productService: ProductService,
    public router: Router,
    public dialogRef: MatDialogRef<ProductCreateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    this.formAddDialog = this.formBuilder.group({
      codeProduct: ['',[Validators.required, Validators.pattern('(SP-)[0-9]{4}')]],
      nameProduct:['',[Validators.required]],
      producer:['',[Validators.required]],
      category:['Smart phone'],
    });
    this.productService.getAllCategory().subscribe(data => {
      this.listCategory = data;
    });
  }

  addNewProductDialog() {
    this.productService.createNewProductService(this.formAddDialog.value).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
