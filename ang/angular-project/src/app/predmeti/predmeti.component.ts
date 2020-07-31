import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

import { Predmet } from '../model/predmet.model';
import { PredmetService } from './predmeti.service';
@Component({
  selector: 'lista-predmeta',
  templateUrl: './predmeti.component.html',
  styleUrls: ['./predmeti.component.css']
})
export class PredmetiComponent implements OnInit {

  predmeti: Predmet[];

  subscription: Subscription;

  constructor(private predmetService: PredmetService, private router: Router) {
    this.subscription = predmetService.RegenerateData$.subscribe(() =>
      this.getPredmeti()
    );
  }

  ngOnInit(): void {
    this.getPredmeti();
  }

  getPredmeti() {
    this.predmetService.getPredmeti().then(predmeti =>
      this.predmeti = predmeti);
  }

  gotoAdd(): void {
    this.router.navigate(['/dodajPredmet']);
  }

  gotoEdit(predmet: Predmet): void {
    this.router.navigate(['/izmeniPredmet', predmet.id]);
  }

  obrisiPredmet(predmetId: number): void {
    this.predmetService.obrisiPredmet(predmetId).then(
      () => this.getPredmeti()
    );
  }
}