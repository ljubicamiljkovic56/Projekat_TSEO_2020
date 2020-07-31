import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

import { PohadjanjePredmeta } from '../model/pohadjanje.model';

import {  } from 'rxjs/add/operator/toPromise';

@Injectable()
export class PohadjanjePredmetaService {
    private pohadjanjaUrl = 'api/pohadjanjepredmeta';
    private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    constructor(private http: HttpClient) { }

    private RegenerateData = new Subject<void>();

    RegenerateData$ = this.RegenerateData.asObservable();

    announceChange() {
        this.RegenerateData.next();
    }

    
    dodajPohadjanjePredmeta(pohadjanjepredmeta: PohadjanjePredmeta): Promise<PohadjanjePredmeta> {
        return this.http
            .post(this.pohadjanjaUrl, JSON.stringify(pohadjanjepredmeta), { headers: this.headers })
            .toPromise()
            .then(res => JSON.parse(JSON.stringify(res)).data as PohadjanjePredmeta)
            .catch(this.handleError);
    }

    obrisiPohadjanjePredmeta(pohadjanjePredmetaId: number): Promise<{}> {
        const url = `${this.pohadjanjaUrl}/${pohadjanjePredmetaId}`;
        return this.http
            .delete(url)
            .toPromise()           
            .catch(this.handleError);
    }

    handleError(error: any): Promise<any> {
        console.error("Greska... ", error);
        return Promise.reject(error.message || error);
    }
}