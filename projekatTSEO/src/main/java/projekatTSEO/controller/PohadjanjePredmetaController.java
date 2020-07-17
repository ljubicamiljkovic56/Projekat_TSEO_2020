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

import projekatTSEO.app.model.PohadjanjePredmeta;
import projekatTSEO.dto.PohadjanjePredmetaDTO;
import projekatTSEO.service.PohadjanjePredmetaService;

@RestController
@RequestMapping(value = "/api/pohadjanjePredmeta")
public class PohadjanjePredmetaController {

	@Autowired
	PohadjanjePredmetaService ppS;
	
	@Autowired
	private ModelMapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PohadjanjePredmetaDTO>> getPohadjanjePredmeta(){
		List<PohadjanjePredmeta> pohadjanja = ppS.findAll();
		List<PohadjanjePredmetaDTO> pDTO = new ArrayList<PohadjanjePredmetaDTO>();
		PohadjanjePredmetaDTO pdto;
		for(PohadjanjePredmeta p : pohadjanja) {
			pdto = mapper.map(p, PohadjanjePredmetaDTO.class);
			pDTO.add(pdto);
		}
		return new ResponseEntity<List<PohadjanjePredmetaDTO>>(pDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PohadjanjePredmetaDTO> getOne(@PathVariable Long id){
		PohadjanjePredmeta p = ppS.findOne(id);
		PohadjanjePredmetaDTO pDTO;
		if(p == null)
			return new ResponseEntity<PohadjanjePredmetaDTO>(HttpStatus.NOT_FOUND);
		pDTO = mapper.map(p, PohadjanjePredmetaDTO.class);
		return new ResponseEntity<PohadjanjePredmetaDTO>(pDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<PohadjanjePredmetaDTO> save(@RequestBody PohadjanjePredmetaDTO pDTO){
		PohadjanjePredmeta p = mapper.map(pDTO, PohadjanjePredmeta.class);
		ppS.save(p);
		return new ResponseEntity<PohadjanjePredmetaDTO>(pDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<PohadjanjePredmetaDTO> update(@RequestBody PohadjanjePredmetaDTO pDTO){
		PohadjanjePredmeta p = mapper.map(pDTO, PohadjanjePredmeta.class);
		PohadjanjePredmetaDTO pdto;
		if(ppS.findOne(p.getId()) == null) {			
			return new ResponseEntity<PohadjanjePredmetaDTO>(HttpStatus.BAD_REQUEST);
		}
		p = ppS.save(p);
		pdto = mapper.map(p, PohadjanjePredmetaDTO.class);
		return new ResponseEntity<PohadjanjePredmetaDTO>(pdto, HttpStatus.OK);			
	}
	
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		PohadjanjePredmeta p = ppS.findOne(id);
		if(p != null) {
			ppS.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
}
