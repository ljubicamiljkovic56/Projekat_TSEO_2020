import {ComponentFixture, TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core'
import {async, fakeAsync, tick} from '@angular/core/testing';

import { StudentiComponent } from './studenti.component';
import { StudentService } from './studenti.service';
import { Student } from '../model/student.model';

describe('StudentsComponent', () => {
  let component: StudentiComponent;
  let fixture: ComponentFixture<StudentiComponent>;
  let studentService: any;
  let router: any;

  beforeEach(() => {
    let studentServiceMock = {
      getStudents: jasmine.createSpy('getStudenti')
          .and.returnValue(Promise.resolve([{}, {}, {}])), 
      deleteStudent: jasmine.createSpy('obrisiStudenta')
        .and.returnValue(Promise.resolve()),
      RegenerateData$: {
        subscribe: jasmine.createSpy('subscribe')
      }
    };

    let routerMock = {
      navigate: jasmine.createSpy('navigate')
    };

    TestBed.configureTestingModule({
       declarations: [ StudentiComponent ],
       providers:    [ {provide: StudentService, useValue: studentServiceMock },
                       { provide: Router, useValue: routerMock } ]
    });

    fixture = TestBed.createComponent(StudentiComponent);
    component    = fixture.componentInstance;
    studentService = TestBed.get(StudentService);
    router = TestBed.get(Router);
  });


  it('preko on init treba da pokupi listu studenata', async(() => {
    component.ngOnInit();
    expect(studentService.RegenerateData$.subscribe).toHaveBeenCalled();
    expect(studentService.getStudents).toHaveBeenCalled();

    fixture.detectChanges();
    fixture.whenStable()
      .then(() => {
        fixture.detectChanges();
        expect(component.studenti.length).toBe(3); 
        let elements: DebugElement[] = fixture.debugElement.queryAll(By.css('table tr'));
        expect(elements.length).toBe(4); 
      });
  }));

  it('treba da doda studenta', () => {
    component.gotoAdd();
    expect(router.navigate).toHaveBeenCalledWith(
      ['/dodajStudenta']);
  });

  it('treba da izmeni studenta', () => {
    let student: Student = new Student({  
        id: 7,
        brojIndeksa: 'SF 1/2018',
        ime: 'Petar',
        prezime: 'Petrovic' 
      });
    component.gotoEdit(student);
    expect(router.navigate).toHaveBeenCalledWith(
      ['/izmeniStudenta', 7]);
  });

  it ('treba da izbrise studenta', () => {
    component.obrisiStudenta(1);

    expect(studentService.obrisiStudenta).toHaveBeenCalledWith(1);    
  }); 

});