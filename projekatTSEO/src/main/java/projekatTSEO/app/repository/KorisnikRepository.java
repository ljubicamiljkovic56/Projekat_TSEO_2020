package projekatTSEO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findByKorisnickoIme(String korisnickoIme);
}
