package projekatTSEO.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.dto.PredavanjePredmetaDTO;
import projekatTSEO.model.PredavanjePredmeta;
import projekatTSEO.service.PredavanjePredmetaService;

@RestController
@RequestMapping(value = "api/predavanjaPredmeta")
public class PredavanjePredmetaController {

	
	@Autowired
	private PredavanjePredmetaService pPService;
	
	@Autowired
	public ModelMapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredavanjePredmetaDTO>> getPredavanja(){
		List<PredavanjePredmeta> predavanja = pPService.findAll();
		List<PredavanjePredmetaDTO> predavanjaDTO = new ArrayList<>();
		PredavanjePredmetaDTO pDTO;
		for(PredavanjePredmeta p : predavanja) {
			pDTO = mapper.map(p, PredavanjePredmetaDTO.class);
			predavanjaDTO.add(pDTO);
		}
		return new ResponseEntity<List<PredavanjePredmetaDTO>>(predavanjaDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredavanjePredmetaDTO> getOne(@PathVariable int id){
		PredavanjePredmeta predavanje = pPService.findOne(id);
		if(predavanje == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		PredavanjePredmetaDTO pDTO = mapper.map(predavanje, PredavanjePredmetaDTO.class);
		return new ResponseEntity<PredavanjePredmetaDTO>(pDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<PredavanjePredmetaDTO> savePredavanje(@RequestBody PredavanjePredmetaDTO pp) {
		PredavanjePredmeta predavanje = mapper.map(pp, PredavanjePredmeta.class);
		PredavanjePredmeta novo = pPService.save(predavanje);
		PredavanjePredmetaDTO pDTO = pp;//mapper.map(novo, PredavanjePredmetaDTO.class);
		return new ResponseEntity<PredavanjePredmetaDTO>(pDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<PredavanjePredmetaDTO> updatePredavanje(@RequestBody PredavanjePredmetaDTO pp){
		PredavanjePredmeta predavanje = mapper.map(pp, PredavanjePredmeta.class);
		if(pPService.findOne(predavanje.getId())==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		predavanje = pPService.save(predavanje);
		PredavanjePredmetaDTO pDTO = mapper.map(predavanje, PredavanjePredmetaDTO.class);
		return new ResponseEntity<PredavanjePredmetaDTO>(pDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredavanje(@PathVariable int id){
		PredavanjePredmeta predavanje = pPService.findOne(id);
		if(predavanje != null) {
			pPService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
