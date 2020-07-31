import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { StudentService } from '../studenti/studenti.service';
import { Student } from '../model/student.model';
import { PohadjanjePredmeta } from '../model/pohadjanje.model';

import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  student: Student;

  pohadjanja: PohadjanjePredmeta[];

  mode: string;    

  constructor(private studentService: StudentService, private route: ActivatedRoute, private location: Location) {
    this.student = new Student({ 
        brojIndeksa: '',
        ime: '',
        prezime: ''
      });

    this.mode = 'ADD'
  }

  ngOnInit() {
    if (this.route.snapshot.params['id']) {
      this.mode = 'EDIT'; 
      this.route.params
        .pipe(switchMap((params: Params) => 
          this.studentService.getStudent(+params['id'])))
        .subscribe(student => {
          this.student = student;
          this.studentService.getStudentPohadjanja(student.id).then(pohadjanja =>
            this.pohadjanja = this.pohadjanja);
          }
        );
    } 
  }

  save(): void {
    this.mode == 'ADD' ? this.add() : this.edit();    
  }

  private add(): void {
    this.studentService.dodajStudenta(this.student)
      .then(student => {
        this.studentService.announceChange();
        this.goBack();
      });
  }

  private edit(): void {
    this.studentService.izmeniStudenta(this.student)
      .then(student => {
        this.studentService.announceChange();
        this.goBack();
      });
  }

  goBack(): void {
    this.location.back();
  }

}