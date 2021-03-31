import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CommonModule} from '@angular/common';
import {CustomerCreateComponent} from './customer/customer-create/customer-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {CustomerDeleteComponent} from './customer/customer-delete/customer-delete.component';
import {MaterialModule} from './material.module';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {CustomerCreateDialogComponent} from './customer/customer-create-dialog/customer-create-dialog.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { CustomerViewComponent } from './customer/customer-view/customer-view.component';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'customer', component: CustomerListComponent},
  {path: 'create-customer', component: CustomerCreateComponent}
];

@NgModule({
  declarations: [HomePageComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerDeleteComponent,
    CustomerEditComponent,
    CustomerCreateDialogComponent,
    CustomerViewComponent],
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MaterialModule,
    Ng2SearchPipeModule,
    FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
