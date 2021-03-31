import {NgModule} from '@angular/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomerDeleteComponent} from './customer/customer-delete/customer-delete.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {CustomerCreateDialogComponent} from './customer/customer-create-dialog/customer-create-dialog.component';
import {CustomerViewComponent} from './customer/customer-view/customer-view.component';

@NgModule({
  imports: [
    // MatDatepickerModule,
    // MatFormFieldModule,
    // MatNativeDateModule,
    // MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule,
  ],
  exports: [
    // MatDatepickerModule,
    // MatFormFieldModule,
    // MatNativeDateModule,
    // MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [
    // MatDatepickerModule
  ],
  entryComponents: [CustomerDeleteComponent, CustomerEditComponent, CustomerCreateDialogComponent, CustomerViewComponent]
})

export class MaterialModule {
}
