import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs';
import { Student } from '../model/student.model';
import { PohadjanjePredmeta } from '../model/pohadjanje.model';

import {  } from 'rxjs/add/operator/toPromise';

@Injectable()
export class StudentService {
    private studentiUrl = 'api/studenti';
    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    constructor(private http: HttpClient){}

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getStudenti(): Promise<Student[]> {
        return this.http.get(this.studentiUrl)
        .toPromise()
        .then(response => 
            //pre je bilo response.json() as Student
            JSON.parse(JSON.stringify(response)).data as Student[])
        .catch(this.handleError);
    }

    getStudent(id: number): Promise<Student> {
        const url = `${this.studentiUrl}/${id}`;
        return this.http.get(url)
            .toPromise()
            .then(response => 
            JSON.parse(JSON.stringify(response)).data as Student)
            .catch(this.handleError);

    }

    dodajStudenta(student: Student): Promise<Student> {
        return this.http
            .post(this.studentiUrl, JSON.stringify(student), { headers: this.headers})
            .toPromise()
            .then(res => JSON.parse(JSON.stringify(res)).data as Student)
            .catch(this.handleError);
    }

    izmeniStudenta(student: Student): Promise<Student> {
        return this.http
            .put(this.studentiUrl, JSON.stringify(student), { headers: this.headers })
            .toPromise()
            .then(res => JSON.parse(JSON.stringify(res)).data as Student)
            .catch(this.handleError);
    }

    obrisiStudenta(studentId: number): Promise<{}> {
        const url = `${this.studentiUrl}/${studentId}`;
        return this.http
            .delete(url)
            .toPromise()
            .catch(this.handleError);
    }

    getStudentPohadjanja(studentId: number): Promise<PohadjanjePredmeta[]>{
        const url = `${this.studentiUrl}/${studentId}/predmeti`;
        return this.http.get(url)
            .toPromise()
            .then(res => JSON.parse(JSON.stringify(res)).data as PohadjanjePredmeta[])
            .catch(this.handleError);
    }

    handleError(error: any): Promise<any> {
        console.error('Greska...', error);
        return Promise.reject(error.message || error);
    }
}