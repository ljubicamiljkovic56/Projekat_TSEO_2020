import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

import { Predmet } from '../model/predmet.model';
import { PohadjanjePredmeta } from '../model/pohadjanje.model';

import {  } from 'rxjs/add/operator/toPromise';

@Injectable()
export class PredmetService {
    private predmetiUrl = 'api/predmeti';
    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    getPredmeti(): Promise<Predmet[]> {
        return this.http.get(this.predmetiUrl)
            .toPromise()
            .then(response =>
            JSON.parse(JSON.stringify(response)).data as Predmet[])
            .catch(this.handleError);
    }

    getPredmet(id: number): Promise<Predmet> {
        const url = `${this.predmetiUrl}/${id}`;
        return this.http.get(url)
            .toPromise()
            .then(response =>
            JSON.parse(JSON.stringify(response)).data as Predmet)
            .catch(this.handleError);
    }

    dodajPredmet(predmet: Predmet): Promise<Predmet> {
        return this.http
            .post(this.predmetiUrl, JSON.stringify(predmet), { headers: this.headers })
            .toPromise()
            .then(res => JSON.parse(JSON.stringify(res)).data as Predmet)
            .catch(this.handleError);
    }

    izmeniPredmet(predmet: Predmet): Promise<Predmet> {
        return this.http
            .put(this.predmetiUrl, JSON.stringify(predmet), { headers: this.headers })
            .toPromise()
            .then(res => JSON.parse(JSON.stringify(res)).data as Predmet)
            .catch(this.handleError);
    }

    obrisiPredmet(predmetId: number): Promise<{}> {
        const url = `${this.predmetiUrl}/${predmetId}`;
        return this.http
            .delete(url)
            .toPromise()           
            .catch(this.handleError);
    }

    getPredmetPohadjanja(predmetId: number): Promise<PohadjanjePredmeta[]> {
        const url = `${this.predmetiUrl}/${predmetId}/studenti`;
        return this.http.get(url)
            .toPromise()
            .then(response =>
            JSON.parse(JSON.stringify(response)).data as Predmet[])
            .catch(this.handleError);
    }

    handleError(error: any): Promise<any> {
        console.error("Greska... ", error);
        return Promise.reject(error.message || error);
    }
}