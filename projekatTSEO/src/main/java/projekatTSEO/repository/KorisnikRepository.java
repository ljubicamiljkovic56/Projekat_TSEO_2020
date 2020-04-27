package projekatTSEO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findByKorisnickoIme(String korisnickoIme);
}
