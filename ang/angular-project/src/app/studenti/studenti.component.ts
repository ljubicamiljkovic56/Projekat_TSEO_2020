import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';

import {Student} from '../model/student.model';
import {StudentService} from '../studenti/studenti.service';
import { Subscription } from 'rxjs';

@Component({
    selector: 'lista-studenata',
    templateUrl: './studenti.component.html',
    styleUrls: ['./studenti.component.css']
})
export class StudentiComponent implements OnInit {
    studenti: Student[];

    subscription: Subscription;

    constructor(private studentService: StudentService, private router: Router){
        this.subscription = studentService.RegenerateData$.subscribe(() => 
        this.getStudenti()
        )
    }
    ngOnInit(): void {
        this.getStudenti();
      }
    
      getStudenti() {
        this.studentService.getStudenti().then(studenti =>
          this.studenti = studenti);
      }
    
      gotoAdd(): void {
        this.router.navigate(['/dodajStudenta']);
      }
    
      gotoEdit(student: Student): void {
        this.router.navigate(['/editStudent', student.id]);
      }
    
      obrisiStudenta(studentId: number): void {
        this.studentService.obrisiStudenta(studentId).then(
          () => this.getStudenti()
        );
      }
}
