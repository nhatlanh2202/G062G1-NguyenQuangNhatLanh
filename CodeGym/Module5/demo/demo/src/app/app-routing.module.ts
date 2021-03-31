import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CommonModule} from "@angular/common";
import {NgxPaginationModule} from "ngx-pagination";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MaterialModule} from "./material.module";
import {ProductListComponent} from './products/product-list/product-list.component';
import {ProductCreateComponent} from './products/product-create/product-create.component';
import {ProductEditComponent} from './products/product-edit/product-edit.component';
import {ProductDeleteComponent} from './products/product-delete/product-delete.component';
import {OrderModule} from "ngx-order-pipe";
import {FeedbackListComponent} from './feedback/feedback-list/feedback-list.component';
import { FeedbackContentComponent } from './feedback/feedback-content/feedback-content.component';
import { MemberCardListComponent } from './member-card/member-card-list/member-card-list.component';
import { MemberCardPageComponent } from './member-card-main/member-card-page/member-card-page.component';
import { MemberCardCreateComponent } from './member-card-main/member-card-create/member-card-create.component';


const routes: Routes = [
  {path: '', component: ProductListComponent},

  {path: 'feedback-list', component: FeedbackListComponent},

  {path: 'member-card', component: MemberCardListComponent},

  {path: 'member-card/list', component: MemberCardPageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MaterialModule,
    Ng2SearchPipeModule,
    FormsModule,
    OrderModule
  ],
  exports: [RouterModule],
  declarations: [ProductListComponent, ProductCreateComponent, ProductEditComponent, ProductDeleteComponent, FeedbackListComponent, FeedbackContentComponent, MemberCardListComponent, MemberCardPageComponent, MemberCardCreateComponent]
})
export class AppRoutingModule {
}
