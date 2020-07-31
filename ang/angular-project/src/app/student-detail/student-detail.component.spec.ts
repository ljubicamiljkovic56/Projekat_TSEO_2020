import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { async, fakeAsync, tick } from '@angular/core/testing';

import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core'

import { StudentDetailComponent } from './student-detail.component';
import { StudentService } from '../studenti/studenti.service';
import { ActivatedRouteStub } from '../test/router-stubs';
import { Student } from "app/model/student.model";

describe('StudentDetailComponent', () => {
  let componentForAdd: StudentDetailComponent;
  let fixture: ComponentFixture<StudentDetailComponent>;
  let studentService: any;
  let activatedRoute: any;
  let location: any;

 beforeEach(() => {
    let studentServiceMock = {
      getStudent: jasmine.createSpy('getStudent')
        .and.returnValue(Promise.resolve(new Student({
            id: 1,
            brojIndeksa: 'SF 1/2018',
            ime: 'Petar',
            prezime: 'Petrovic'            
         	}))),
      getStudentPohadjanja: jasmine.createSpy('getStudentPohadjanja')
        .and.returnValue(Promise.resolve([
          {
            id: 1,
            pocetak: Date.UTC(2018, 0, 1),
            kraj: Date.UTC(2019, 0, 1),
            student: {
                id: 1,
                brojIndeksa: 'SF 1/2018',
                ime: 'Petar',
                prezime: 'Petrovic'            
            }, 
            predmet: {
              id: 7,
              naziv: 'Matematika'
            }
          },
          {
            id: 2,
            pocetak: Date.UTC(2018, 0, 1),
            kraj: Date.UTC(2019, 0, 1),
            student: {
                id: 1,
                brojIndeksa: 'SF 1/2018',
                ime: 'Petar',
                prezime: 'Petrovic'           
            }, 
            predmet: {
              id: 8,
              naziv: 'Programiranje'
            }
          }])),
      dodajStudenta: jasmine.createSpy('dodajStudenta')
          .and.returnValue(Promise.resolve()),
      izmeniStudenta: jasmine.createSpy('izmeniStudenta')
          .and.returnValue(Promise.resolve()),
      announceChange: jasmine.createSpy('announceChange') 
    };

    let locationMock = {
      back: jasmine.createSpy('back')
    };

    let activatedRouteStub: ActivatedRouteStub = new ActivatedRouteStub();
    activatedRouteStub.testParams = { id: 1 } ; 

    TestBed.configureTestingModule({
       declarations: [ StudentDetailComponent ],
       imports: [ FormsModule ],
       providers:    [ 
        {provide: StudentService, useValue: studentServiceMock },
        { provide: ActivatedRoute, useValue: activatedRouteStub },
        { provide: Location, useValue: locationMock} ]
    });

    fixture = TestBed.createComponent(StudentDetailComponent);
    componentForAdd = fixture.componentInstance;
    studentService = TestBed.get(StudentService);
    activatedRoute = TestBed.get(ActivatedRoute);
    location = TestBed.get(Location);
  }); 
  
  it('should fetch student and his enrollments on init in edit mode', fakeAsync(() => {
    componentForAdd.ngOnInit();
    expect(studentService.getStudent).toHaveBeenCalledWith(1); 
    tick();
    
    expect(componentForAdd.student.id).toBe(1);
    expect(componentForAdd.student.brojIndeksa).toEqual('SF 1/2018');
    expect(componentForAdd.student.ime).toEqual('Petar');
    expect(componentForAdd.student.prezime).toEqual('Petrovic');
    
    expect(studentService.getStudentPohadjanja).toHaveBeenCalledWith(1); 
    expect(componentForAdd.pohadjanja.length).toBe(2);
    expect(componentForAdd.pohadjanja[0].id).toEqual(1);
    expect(componentForAdd.pohadjanja[0].pocetak).toEqual(Date.UTC(2018, 0, 1));
    expect(componentForAdd.pohadjanja[0].kraj).toEqual(Date.UTC(2019, 0, 1));       
    expect(componentForAdd.pohadjanja[0].student.id).toEqual(1);
    expect(componentForAdd.pohadjanja[0].student.brojIndeksa).toEqual('SF 1/2018');
    expect(componentForAdd.pohadjanja[0].student.ime).toEqual('Petar');
    expect(componentForAdd.pohadjanja[0].student.prezime).toEqual('Petrovic');
    expect(componentForAdd.pohadjanja[0].predmet.id).toEqual(7);
    expect(componentForAdd.pohadjanja[0].predmet.naziv).toEqual('Matematika');

    expect(componentForAdd.pohadjanja[1].id).toEqual(2);
    expect(componentForAdd.pohadjanja[1].pocetak).toEqual(Date.UTC(2018, 0, 1));
    expect(componentForAdd.pohadjanja[1].kraj).toEqual(Date.UTC(2019, 0, 1));       
    expect(componentForAdd.pohadjanja[1].student.id).toEqual(1);
    expect(componentForAdd.pohadjanja[1].student.brojIndeksa).toEqual('SF 1/2018');
    expect(componentForAdd.pohadjanja[1].student.ime).toEqual('Petar');
    expect(componentForAdd.pohadjanja[1].student.prezime).toEqual('Petrovic');
    expect(componentForAdd.pohadjanja[1].predmet.id).toEqual(8);
    expect(componentForAdd.pohadjanja[1].predmet.naziv).toEqual('Programiranje');

    fixture.detectChanges();
    tick(); 
    fixture.detectChanges(); 
    let brojIndeksaInput = fixture.debugElement.query(By.css('#field1c')).nativeElement;
    expect(brojIndeksaInput.value).toEqual('SF 1/2018');
    let imeInput = fixture.debugElement.query(By.css('#field2c')).nativeElement;
    expect(imeInput.value).toEqual('Petar');
    let prezimeInput = fixture.debugElement.query(By.css('#field3c')).nativeElement;
    expect(prezimeInput.value).toEqual('Petrovic');

    let pohadjanjeElementi: DebugElement[] = fixture.debugElement.queryAll(By.css('table tr'));
    expect(pohadjanjeElementi.length).toBe(2); 
    let naziviPredmeta: DebugElement[] = fixture.debugElement.queryAll(By.css('table tr td'));
    expect(naziviPredmeta.length).toBe(2);
    expect(naziviPredmeta[0].nativeElement.textContent).toContain('Matematika');
    expect(naziviPredmeta[1].nativeElement.textContent).toContain('Programiranje');
  }));


  
  function newEvent(eventName: string, bubbles = false, cancelable = false) {
    let evt = document.createEvent('CustomEvent');  
    evt.initCustomEvent(eventName, bubbles, cancelable, null);
    return evt;
  }

  it('should bind data from edit fields to student', fakeAsync(() => {
      fixture.detectChanges();  
      tick();
      expect(componentForAdd.student.brojIndeksa).not.toEqual('SF 1/2018');
      expect(componentForAdd.student.ime).not.toEqual('Petar1');
      expect(componentForAdd.student.prezime).not.toEqual('Petrovic1');

      let brojIndeksaInput = fixture.debugElement.query(By.css('#field1c')).nativeElement;
      brojIndeksaInput.value = 'SF 1/2018';
      let imeInput = fixture.debugElement.query(By.css('#field2c')).nativeElement;
      imeInput.value = 'Petar1';
      let prezimeInput = fixture.debugElement.query(By.css('#field3c')).nativeElement;
      prezimeInput.value  = 'Petrovic1';

      brojIndeksaInput.dispatchEvent(newEvent('input')); 
      imeInput.dispatchEvent(newEvent('input')); 
      prezimeInput.dispatchEvent(newEvent('input')); 

      
      expect(componentForAdd.student.brojIndeksa).toEqual('SF 1/2018');
      expect(componentForAdd.student.ime).toEqual('Petar1');
      expect(componentForAdd.student.prezime).toEqual('Petrovic1');
  }));

  it('treba da doda studenta', fakeAsync(() => {

    componentForAdd.save();
    expect(studentService.dodajStudenta).toHaveBeenCalled();
    tick();
    expect(studentService.announceChange).toHaveBeenCalled();
    expect(location.back).toHaveBeenCalled();
  }));

  it('treba da izmeni studenta', fakeAsync(() => {
    componentForAdd.ngOnInit(); 
    componentForAdd.save();
    expect(studentService.izmeniStudenta).toHaveBeenCalled();
    tick();
    expect(studentService.announceChange).toHaveBeenCalled();
    expect(location.back).toHaveBeenCalled();
  }));

  it('should go back on goBack()', () => {
    componentForAdd.goBack();
    expect(location.back).toHaveBeenCalled();
  });
});