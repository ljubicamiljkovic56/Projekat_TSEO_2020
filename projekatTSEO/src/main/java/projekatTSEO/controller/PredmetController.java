package projekatTSEO.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.dto.PredmetDTO;
import projekatTSEO.model.Predmet;
import projekatTSEO.service.PredmetService;


@RestController
@RequestMapping(value = "api/predmeti")
public class PredmetController {
	
	@Autowired
	private PredmetService predmetService;
	
	
	//nadji sve predmete
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getPredmeti() {
		List<Predmet> predmeti = predmetService.findAll();
		List<PredmetDTO> predmetDTO = new ArrayList<>();
		for (Predmet pr : predmeti) {
			predmetDTO.add(new PredmetDTO(pr));
		}
		return new ResponseEntity<>(predmetDTO, HttpStatus.OK);
	}
	
	//nadji predmete po id-u
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getPredmet(@PathVariable int id){
		Predmet predmet = predmetService.findOne(id);
		if(predmet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PredmetDTO(predmet), HttpStatus.OK);
	}
	
	//sacuvaj predmet
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<PredmetDTO> savePredmet(@RequestBody PredmetDTO predmetDTO){
		Predmet predmet = new Predmet();
		predmet.setNaziv(predmetDTO.getNaziv());
	
		predmet = predmetService.save(predmet);
		return new ResponseEntity<>(new PredmetDTO(predmet), HttpStatus.CREATED);	
	}
	
	
	//izmeni predmet
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<PredmetDTO> updateCourse(@RequestBody PredmetDTO predmetDTO){
		Predmet predmet = predmetService.findOne(predmetDTO.getId()); 
		if (predmet == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		predmet.setNaziv(predmetDTO.getNaziv());
	
		predmet = predmetService.save(predmet);
		return new ResponseEntity<>(new PredmetDTO(predmet), HttpStatus.OK);	
	}
	
	//obrisi predmet
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredmet(@PathVariable int id){
		Predmet predmet = predmetService.findOne(id);
		if (predmet != null){
			predmetService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
