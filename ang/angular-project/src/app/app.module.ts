import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import {  } from '@angular/common/http';

import { AppRoutingModule } from './app-routing';
import { AppComponent } from './app.component';

import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { map } from 'rxjs/operators';

import { StudentiComponent } from './studenti/studenti.component';
import { PredmetiComponent } from './predmeti/predmeti.component';
import { StudentService } from './studenti/studenti.service';
import { PredmetService } from './predmeti/predmeti.service';
import { PohadjanjePredmetaService } from './pohadjanje/pohadjanje.service';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { PredmetDetailComponent } from './predmet-detail/predmet-detail.component';
import { PohadjanjePredmetaDetailComponent } from './pohadjanje-detail/pohadjanje-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentiComponent,
    PredmetiComponent,
    StudentDetailComponent,
    PredmetDetailComponent,
    PohadjanjePredmetaDetailComponent
  ],
  imports: [
    //NgModule.forRoot(),
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [StudentService, PredmetService, PohadjanjePredmetaService],
  bootstrap: [AppComponent]
})
export class AppModule { }