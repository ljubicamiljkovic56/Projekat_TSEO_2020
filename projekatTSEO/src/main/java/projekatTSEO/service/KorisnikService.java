package projekatTSEO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatTSEO.model.Korisnik;
import projekatTSEO.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	public KorisnikRepository korisnikRepository;
	
	 public String proveriKorisnika(String korisnickoIme, String lozinka) {
	    	Korisnik korisnik = korisnikRepository.findByKorisnickoIme(korisnickoIme);
	    	if(korisnik == null) {
	    		System.out.println("Nema korisnika sa tim korisnickim imenom");
	    	}else if (korisnik.getLozinka().equals(lozinka)){
	    		if(korisnik.getUloga().equals("admin")) {
	    			System.out.println("Ulogovali ste se kao admin");
	    		}else {
	    			System.out.println("Ulogovali ste se kao student");
	    		}
	    	}else {
	    		System.out.println("Greska");
	    		
	    	}
	    	return korisnik.getUloga().toString();
	    }

}
