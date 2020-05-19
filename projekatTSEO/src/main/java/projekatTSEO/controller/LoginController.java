package projekatTSEO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.service.KorisnikService;


@RestController
public class LoginController {

	@Autowired
	public KorisnikService korisnikService;	
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestParam String korisnickoIme, @RequestParam String lozinka) {
		System.out.println(korisnickoIme);
		System.out.println(lozinka);
		
		String korisnikAuth = korisnikService.proveriKorisnika(korisnickoIme, lozinka);
		
		
		
		return new ResponseEntity<String>(korisnikAuth, HttpStatus.CREATED);
      
	}

}
