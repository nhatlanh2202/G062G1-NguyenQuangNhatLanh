import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {MaterialModule} from "./material.module";
import {NgxPaginationModule} from "ngx-pagination";
import {CommonModule} from "@angular/common";
import { FeedbackListComponent } from './feedback/feedback-list/feedback-list.component';
import { FeedbackContentDialogComponent } from './feedback/feedback-content-dialog/feedback-content-dialog.component';



const routes: Routes = [
  {path: 'feedback-list', component: FeedbackListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MaterialModule,
    FormsModule
  ],
  exports: [RouterModule],
  declarations: [FeedbackListComponent, FeedbackContentDialogComponent]
})
export class AppRoutingModule { }
