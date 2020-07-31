export class Predmet implements PredmetInterface {
    public id: number;
    public naziv: string;

    constructor(predmetCfg: PredmetInterface)
    {
        this.id = predmetCfg.id;
        this.naziv = predmetCfg.naziv;
    }

}

interface PredmetInterface {
    id?: number;
    naziv: string;
}