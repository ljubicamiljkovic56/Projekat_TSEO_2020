import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {StudentiComponent} from './studenti/studenti.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {PredmetDetailComponent} from './predmet-detail/predmet-detail.component';
import {PohadjanjePredmetaDetailComponent} from './pohadjanje-detail/pohadjanje-detail.component';
import {PredmetiComponent} from './predmeti/predmeti.component';
import { ModuleWithProviders } from '@angular/compiler/src/core';


const routes: Routes = [
  {path: '', component: StudentiComponent},
  {path: 'studenti', component: StudentiComponent},
  {path : 'predmeti', component: PredmetiComponent},
  {path: 'dodajStudenta', component: StudentDetailComponent},
  {path: 'izmeniStudenta/:id', component: StudentDetailComponent},
  {path: 'dodajPredmet', component: PredmetDetailComponent},
  {path: 'izmeniPredmet/:id', component: PredmetDetailComponent},
  {path: 'dodajPohadjanje', component: PohadjanjePredmetaDetailComponent},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);