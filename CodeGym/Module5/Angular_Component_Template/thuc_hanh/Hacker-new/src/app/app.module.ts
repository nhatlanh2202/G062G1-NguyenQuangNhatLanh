import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HackernewsComponent } from './hackernews/hackernews.component';
import {FormsModule} from '@angular/forms';
import { LikesComponent } from './likes/likes.component';

@NgModule({
  declarations: [
    AppComponent,
    HackernewsComponent,
    LikesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
