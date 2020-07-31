import { Student } from './student.model';
import { Predmet } from './predmet.model';

export class PohadjanjePredmeta implements PohadjanjePredmetaInterface {
    public id: number;
    public pocetak: Date;
    public kraj: Date;
    public student: Student;
    public predmet: Predmet;

    constructor(pohadjanjePredmetaCfg: PohadjanjePredmetaInterface)
    {
        this.id = pohadjanjePredmetaCfg.id;
        this.pocetak = pohadjanjePredmetaCfg.pocetak;
        this.kraj = pohadjanjePredmetaCfg.kraj;
        this.student = pohadjanjePredmetaCfg.student;
        this.predmet = pohadjanjePredmetaCfg.predmet;
    }
}

interface PohadjanjePredmetaInterface {
    id?: number;
    pocetak: Date;
    kraj: Date;
    student: Student;
    predmet: Predmet;

}