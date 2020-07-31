import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { PohadjanjePredmeta } from '../model/pohadjanje.model';
import { Student } from '../model/student.model';
import { Predmet } from '../model/predmet.model';

import { PredmetService } from '../predmeti/predmeti.service';
import { StudentService } from "../studenti/studenti.service";
import { PohadjanjePredmetaService } from "../pohadjanje/pohadjanje.service";
import { NgbDate, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbDateStruct } from "@ng-bootstrap/ng-bootstrap";
imports: [NgbModule]

@Component({
  selector: 'app-pohadjanje-detail',
  templateUrl: './pohadjanje-detail.component.html',
  styleUrls: ['./pohadjanje-detail.component.css']
})
export class PohadjanjePredmetaDetailComponent implements OnInit {

  pohadjanje: PohadjanjePredmeta;
  studenti: Student[];

  ngbPocetak: NgbDateStruct;
  ngbKraj: NgbDateStruct;

  constructor(private route: ActivatedRoute, private predmetService: PredmetService,
    private studentService: StudentService, private pohadjanjeService: PohadjanjePredmetaService,
    private location: Location) {
    this.pohadjanje = new PohadjanjePredmeta({
      pocetak: null,
      kraj: null,
      student: new Student({
        brojIndeksa: '',
        ime: '',
        prezime: ''
      }),
      predmet: new Predmet({
        naziv: ''
      })
    });

  }

  ngOnInit() {
    this.route.queryParams.subscribe(params =>
      this.predmetService.getPredmet(params['predmetId'])
        .then(predmet => 
          this.pohadjanje.predmet = predmet 
        ));

    this.studentService.getStudenti().then(studenti =>
      this.studenti = studenti);
  }

  public add(): void {
   // this.pohadjanje.pocetak = new Date(this.ngbPocetak.year, this.ngbPocetak.month-1, this.ngbPocetak.day);
   // this.pohadjanje.kraj = new Date(this.ngbKraj.year, this.ngbKraj.month-1, this.ngbKraj.day);

    this.pohadjanjeService.dodajPohadjanjePredmeta(this.pohadjanje)
      .then(pohadjanje => {
        this.pohadjanjeService.announceChange();
        this.goBack();
      });
  }

  goBack(): void {
    this.location.back();
  }

}