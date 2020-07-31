import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { DatePipe } from '@angular/common';

import { PredmetService } from '../predmeti/predmeti.service';
import { PohadjanjePredmetaService } from '../pohadjanje/pohadjanje.service';
import { Predmet } from '../model/predmet.model';
import { PohadjanjePredmeta } from '../model/pohadjanje.model';

import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-predmet-detail',
  templateUrl: './predmet-detail.component.html',
  styleUrls: ['./predmet-detail.component.css']
})
export class PredmetDetailComponent implements OnInit {
    predmet: Predmet = new Predmet({ 
    naziv: '',
  });

  pohadjanja: PohadjanjePredmeta[];

  mode: string = 'ADD';

  constructor(private predmetService: PredmetService, private pohadjanjeService: PohadjanjePredmetaService,
    private route: ActivatedRoute, private location: Location, private router: Router) {
    pohadjanjeService.RegenerateData$.subscribe(() =>
      this.getPohadjanja()
    );
  }

  ngOnInit() {
    if (this.route.snapshot.params['id']) {
      this.mode = 'EDIT';
      this.route.params
        .pipe(switchMap((params: Params) =>
          this.predmetService.getPredmet(+params['id'])))
        .subscribe(predmet => {
          this.predmet = predmet;
          this.getPohadjanja();
        });
    }
  }

  private getPohadjanja(): void {
    this.predmetService.getPredmetPohadjanja(this.predmet.id).then(pohadjanja =>
      this.pohadjanja = pohadjanja);
  }


  save(): void {
    this.mode == 'ADD' ? this.add() : this.edit();
  }

  private add(): void {
    this.predmetService.dodajPredmet(this.predmet)
      .then(predmet => {
        this.predmetService.announceChange();
        this.goBack();
      });
  }

  private edit(): void {
    this.predmetService.izmeniPredmet(this.predmet)
      .then(predmet => {
        this.predmetService.announceChange();
        this.goBack();
      });
  }

  goBack(): void {
    this.location.back();
  }

  gotoAddEnrollment(): void {
    this.router.navigate(['/dodajPohadjanje'], { queryParams: { courseId: this.predmet.id } });
  }

  obrisiPohadjanje(pohadjanjeId: number): void {
    this.pohadjanjeService.obrisiPohadjanjePredmeta(pohadjanjeId).then(
      () => this.getPohadjanja()
    );
  }

}