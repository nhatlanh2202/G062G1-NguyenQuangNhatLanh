import {NgModule} from '@angular/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ProductCreateComponent} from "./products/product-create/product-create.component";
import {ProductEditComponent} from "./products/product-edit/product-edit.component";
import {ProductDeleteComponent} from "./products/product-delete/product-delete.component";
import {FeedbackContentComponent} from "./feedback/feedback-content/feedback-content.component";
import {MemberCardCreateComponent} from "./member-card-main/member-card-create/member-card-create.component";


@NgModule({
  imports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule,
  ],
  exports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [
    MatDatepickerModule
  ],
  entryComponents: [ProductCreateComponent, ProductEditComponent, ProductDeleteComponent, FeedbackContentComponent, MemberCardCreateComponent]
})

export class MaterialModule {
}
