DROP schema IF EXISTS tseo;
CREATE SCHEMA tseo DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE tseo;

INSERT INTO uloga (naziv) VALUES ('admin');
INSERT INTO uloga (naziv) VALUES ('profesor');
INSERT INTO uloga (naziv) VALUES ('student');

INSERT INTO korisnik (korisnicko_ime, lozinka) VALUES ('pera', 'pera');
INSERT INTO korisnik (korisnicko_ime, lozinka) VALUES ('ana', 'ana');
INSERT INTO korisnik (korisnicko_ime, lozinka) VALUES ('mile', 'mile');

INSERT INTO korisnikova_uloga (korisnik_id, uloga_id) VALUES (1, 1);
INSERT INTO korisnikova_uloga (korisnik_id, uloga_id) VALUES (2, 2);
INSERT INTO korisnikova_uloga (korisnik_id, uloga_id) VALUES (3, 3);

INSERT INTO predmet (naziv, bodovi) VALUES ('Osnove web programiranja', 6);
INSERT INTO predmet (naziv, bodovi) VALUES ('Engleski jezik', 4);
INSERT INTO predmet (naziv, bodovi) VALUES ('Matematika 2', 8);

INSERT INTO dokument (vrsta_dokumenta) VALUES ('upisnica');

INSERT INTO uplata (uplatilac, svrha_uplate, primalac, sifra_placanja, valuta, iznos, racun_primaoca, broj_modela, poziv_na_broj, mesto_uplate, datum_uplate, datum_valute, potpis)
			VALUES (3, 'Uplata za ispitni rok', 'Fakultet Tehnickih Nauka', 127, 'dinar', 1000, '123456', 123, '73884-992', 'Novi Sad', '2020-01-04', '2020-01-04', true);
			
INSERT INTO student (korisnicko_ime, lozinka, ime, prezime, uloga, broj_indeksa, pohadjanje_predmeta, polozeni_predmeti, nepolozeni_predmeti, dokumenta, uplate) VALUES ('mile', 'mile', 'Mile', 'Milic', 3, 'SF 33/2018', 1, 2, 3, 1, 1);			
			
INSERT INTO profesor (korisnicko_ime, lozinka, ime, prezime, uloga, zvanje, predaje_predmete) VALUES ('ana', 'ana', 'Ana', 'Mitic', 2, 'redovni profesor', 1);

INSERT INTO predavanjePredmeta (predmet, profesori) VALUES (1, 2);

INSERT INTO pohadjanjePredmeta (pocetak, kraj, predmet, predavaci, studenti) VALUES ('2019-10-02', '2020-01-10', 1, 1, 3);

INSERT INTO ispitPeriod (naziv, pocetak_roka, kraj_roka) VALUES ('Januarski 2020', '2020-01-12', '2020-01-31');

INSERT INTO ispit (datum, student, predmet, ispit_period, broj_bodova, kolokvijum_bodovi, p_obaveze_bodovi) VALUES ('2020-01-25', 1, 1, 1, 30, 30, 28);






