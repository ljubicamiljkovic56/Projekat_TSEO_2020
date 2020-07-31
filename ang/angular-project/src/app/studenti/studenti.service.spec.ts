import { TestBed } from '@angular/core/testing';
import {StudentService} from './studenti.service';
import { Student } from '../model/student.model';
import { PohadjanjePredmeta } from '../model/pohadjanje.model';
import {BaseRequestOptions, ConnectionBackend, Http, RequestOptions} from '@angular/http';
import {Response, ResponseOptions, RequestMethod} from '@angular/http';
import {MockBackend} from '@angular/http/testing';
import {async, fakeAsync, tick} from '@angular/core/testing';

describe('StudentService', () => {

	beforeEach(() => {

    TestBed.configureTestingModule({
       providers:    [ 
          {provide: ConnectionBackend, useClass: MockBackend},
          {provide: RequestOptions, useClass: BaseRequestOptions},
          Http,
          StudentService ]
    });

    this.studentService = TestBed.get(StudentService);
    this.backend = TestBed.get(ConnectionBackend);
    this.backend.connections.subscribe((connection: any) => 
       this.lastConnection = connection);
	});
 	
 	it('should pass simple test', () => {
	    expect(true).toBe(true);
	});

	it('getStudenti() should query current service url', () => {
    this.studentService.getStudenti();
    expect(this.lastConnection).toBeDefined('no http service connection at all?');
    expect(this.lastConnection.request.url).toMatch(/api\/studenti$/, 'url invalid');
	}); 

	it('getStudenti() should return some students', fakeAsync(() => {
     let studenti: Student[];
     this.studentService.getStudenti().then((data: Student[]) => studenti = data);
     this.lastConnection.mockRespond(new Response(new ResponseOptions({
       body: JSON.stringify([
       	{
          id: 1,
          brojIndeksa: 'SF 1/2018',
          ime: 'Petar',
          prezime: 'Petrovic'            
       	},
        {
          id: 2,
          brojIndeksa: 'SF 2/2018',
          ime: 'Mirko',
          prezime: 'Mirkovic'            
        }])
     })));
     tick();
     expect(studenti.length).toEqual(2, 'should contain given amount of students');
     expect(studenti[0].id).toEqual(1);
     expect(studenti[0].brojIndeksa).toEqual('SF 1/2018');
     expect(studenti[0].ime).toEqual('Petar');
     expect(studenti[0].prezime).toEqual('Petrovic');

     expect(studenti[1].id).toEqual(2);
     expect(studenti[1].brojIndeksa).toEqual('SF 2/2018');
     expect(studenti[1].ime).toEqual('Mirko');
     expect(studenti[1].prezime).toEqual('Mirkovic');       
  }));

  it('getStudent() should query url and get a student', fakeAsync(() => {
    let student: Student;
    this.studentService.getStudent(1).then((s: Student) => student = s);
    
    expect(this.lastConnection).toBeDefined('no http service connection at all?');
    expect(this.lastConnection.request.url).toMatch(/api\/studenti\/1$/, 'url invalid');

    this.lastConnection.mockRespond(new Response(new ResponseOptions({
       body: JSON.stringify(
        {
          id: 1,
          brojIndeksa: 'SF 1/2018',
          ime: 'Petar',
          prezime: 'Petrovic'            
        })
     })));
     tick();
     expect(student).toBeDefined();
     expect(student.id).toEqual(1);
     expect(student.brojIndeksa).toEqual('SF 1/2018');
     expect(student.ime).toEqual('Petar');
     expect(student.prezime).toEqual('Petrovic');

  })); 

  it('dodajStudenta() should query url and save a student', fakeAsync(() => {
    let student: Student = new Student({
      brojIndeksa: 'SF 1/2018',
      ime: 'Petar',
      prezime: 'Petrovic' 
    });
    this.studentService.dodajStudenta(student).then((s: Student) => student = s);
    
    expect(this.lastConnection).toBeDefined('no http service connection at all?');
    expect(this.lastConnection.request.url).toMatch(/api\/studenti$/, 'url invalid');
    expect(this.lastConnection.request.method).toEqual(RequestMethod.Post, 'invalid http method');

    this.lastConnection.mockRespond(new Response(new ResponseOptions({
       body: JSON.stringify(
        {
          id: 1,
          brojIndeksa: 'SF 1/2018',
          ime: 'Petar',
          prezime: 'Petrovic'            
        })
     })));
     tick();
     expect(student).toBeDefined();
     expect(student.id).toEqual(1);
     expect(student.brojIndeksa).toEqual('SF 1/2018');
     expect(student.ime).toEqual('Petar');
     expect(student.prezime).toEqual('Petrovic');
  }));

  it('izmeniStudenta() should query url and edit a student', fakeAsync(() => {
    let student: Student = new Student({  
      id: 1,
      brojIndeksa: 'SF 1/2018',
      ime: 'Petar',
      prezime: 'Petrovic' 
    });
    this.studentService.izmeniStudenta(student).then((s: Student) => student = s);
    
    expect(this.lastConnection).toBeDefined('no http service connection at all?');
    expect(this.lastConnection.request.url).toMatch(/api\/studenti$/, 'url invalid');
    expect(this.lastConnection.request.method).toEqual(RequestMethod.Put, 'invalid http method');

    this.lastConnection.mockRespond(new Response(new ResponseOptions({
       body: JSON.stringify(
        {
          id: 1,
          brojIndeksa: 'SF 1/2018',
          ime: 'Petar',
          prezime: 'Petrovic'            
        })
     })));
     tick();
     expect(student).toBeDefined();
     expect(student.id).toEqual(1);
     expect(student.brojIndeksa).toEqual('SF 1/2018');
     expect(student.ime).toEqual('Petar');
     expect(student.prezime).toEqual('Petrovic');
  }));

   it('obrisiStudenta() should query url and delete a student', () => {
    this.studentService.obrisiStudenta(1);
    
    expect(this.lastConnection).toBeDefined('no http service connection at all?');
    expect(this.lastConnection.request.url).toMatch(/api\/studenti\/1$/, 'url invalid');
    expect(this.lastConnection.request.method).toEqual(RequestMethod.Delete, 'invalid http method');
  });

  it('getStudentEnrollments() should query url and get enrollments', fakeAsync(() => {
    let pohadjanja: PohadjanjePredmeta[];

    this.studentService.getStudentPohadjanja(1).then((data: PohadjanjePredmeta[]) => pohadjanja = data);
    expect(this.lastConnection).toBeDefined('no http service connection at all?');
    expect(this.lastConnection.request.url).toMatch(/api\/studenti\/1\/courses$/, 'url invalid');

    this.lastConnection.mockRespond(new Response(new ResponseOptions({
      body: JSON.stringify([
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
          startDate: Date.UTC(2018, 0, 1),
          endDate: Date.UTC(2019, 0, 1),
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
        }]),
     })));
     tick();
     expect(pohadjanja.length).toEqual(2, 'should contain given amount of enrollments');

     expect(pohadjanja[0].id).toEqual(1);
     expect(pohadjanja[0].pocetak).toEqual(Date.UTC(2018, 0, 1));
     expect(pohadjanja[0].kraj).toEqual(Date.UTC(2019, 0, 1));       
     expect(pohadjanja[0].student.id).toEqual(1);
     expect(pohadjanja[0].student.brojIndeksa).toEqual('SF 1/2018');
     expect(pohadjanja[0].student.ime).toEqual('Petar');
     expect(pohadjanja[0].student.prezime).toEqual('Petrovic');
     expect(pohadjanja[0].predmet.id).toEqual(7);
     expect(pohadjanja[0].predmet.naziv).toEqual('Matematika');

     expect(pohadjanja[1].id).toEqual(2);
     expect(pohadjanja[1].pocetak).toEqual(Date.UTC(2018, 0, 1));
     expect(pohadjanja[1].kraj).toEqual(Date.UTC(2019, 0, 1));       
     expect(pohadjanja[1].student.id).toEqual(1);
     expect(pohadjanja[1].student.brojIndeksa).toEqual('SF 1/2018');
     expect(pohadjanja[1].student.ime).toEqual('Petar');
     expect(pohadjanja[1].student.prezime).toEqual('Petrovic');
     expect(pohadjanja[1].predmet.id).toEqual(8);
     expect(pohadjanja[1].predmet.naziv).toEqual('Programiranje');
  })); 


  it('announceChange() should emit the event RegenerateData', fakeAsync(() => {
    let counter: number = 0;
    this.studentService.RegenerateData$.subscribe(() =>  counter++
    );

    this.studentService.announceChange();
    tick();
    this.studentService.announceChange();
    tick();

    expect(counter).toBe(2);
  }));

  it ('handleError() should log error and reject a promise', fakeAsync(() => {
    spyOn(this.studentService, 'handleError').and.callThrough();
    spyOn(console, 'error'); 
    let rejected: boolean = false;

    this.studentService.handleError(new Error('ERROR')).then(null, () => {
      rejected = true;
    });

    expect(console.error).toHaveBeenCalled();

    tick();
    expect(rejected).toBe(true);
  })); 

  it('should call handleError if getStudents produces an error', fakeAsync(() => {     
    spyOn(this.studentService, 'handleError');
    
    this.studentService.getStudenti();
    
    this.lastConnection.mockError(new Error());

    tick();

    expect(this.studentService.handleError).toHaveBeenCalled();
  }));


  it('should call handleError if any method with HTTP call produce an error', () => {
      let testServiceMethodsForErrors = function(methods: Array<Function>): void  {

      let checkIsErrorHandlerCalled = function(method: Function): void {
        spyOn(this.studentService, 'handleError');            
        method.apply(this.studentService);     
        this.lastConnection.mockError(new Error());
        tick();
        expect(this.studentService.handleError).toHaveBeenCalled();
      };

      for (let method of methods) {
        fakeAsync((method: Function) => {
          checkIsErrorHandlerCalled(method);
        });
      }     
    };

    
    testServiceMethodsForErrors([this.studentService.getStudenti, this.studentService.getStudent,
      this.studentService.dodajStudenta, this.studentService.izmeniStudenta, this.studentService.obrisiStudenta,
      this.studentService.getStudentPohadjanja]);
  });
});