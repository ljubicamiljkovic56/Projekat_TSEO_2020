export class Student implements StudentInterface {
    public id: number;
    public brojIndeksa: string;
    public ime: string;
    public prezime: string;

    constructor(studentCfg:StudentInterface) {
        this.id = studentCfg.id;
        this.brojIndeksa = studentCfg.brojIndeksa;
        this.ime = studentCfg.ime;
        this.prezime = studentCfg.prezime;
    }
}
interface StudentInterface {
    id?: number;
    brojIndeksa?: string;
    ime?: string;
    prezime?: string;
}