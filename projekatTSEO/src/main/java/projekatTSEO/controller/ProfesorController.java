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

import projekatTSEO.app.model.Profesor;
import projekatTSEO.dto.ProfesorDTO;
import projekatTSEO.service.ProfesorService;

@RestController
@RequestMapping(value = "/api/profesori")
public class ProfesorController {

	@Autowired
	private ProfesorService profesorService;
	
	@Autowired
	public ModelMapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTO>> getProfesori(){
		List<ProfesorDTO> profesoriDTO = new ArrayList<ProfesorDTO>();
		ProfesorDTO pDTO;
		List<Profesor> profesori = profesorService.findAll();
		for(Profesor p : profesori) {
			pDTO = mapper.map(p, ProfesorDTO.class);
			profesoriDTO.add(pDTO);
		}		
		return new ResponseEntity<List<ProfesorDTO>>(profesoriDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfesorDTO> getProfesor(@PathVariable Long id){
		Profesor p = profesorService.findOne(id);
		if(p == null)
			return new ResponseEntity<ProfesorDTO>(HttpStatus.NOT_FOUND);
		ProfesorDTO pDTO = mapper.map(p, ProfesorDTO.class);
		return new ResponseEntity<ProfesorDTO>(pDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ProfesorDTO> saveProfesor(@RequestBody ProfesorDTO pDTO){
		Profesor p = mapper.map(pDTO, Profesor.class);
		Profesor novi = profesorService.save(p);
		ProfesorDTO pd = mapper.map(novi, ProfesorDTO.class); //nisam sigurna da li mi ovo zapravo treba ili sam mogla samo da ostavim pDTO
		return new ResponseEntity<ProfesorDTO>(pd, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<ProfesorDTO> updateProfesor(@RequestBody ProfesorDTO pDTO){
		Profesor p = mapper.map(pDTO, Profesor.class);
		if(profesorService.findOne(p.getId()) == null)
			return new ResponseEntity<ProfesorDTO>(HttpStatus.NOT_FOUND);
		ProfesorDTO pd = mapper.map(p, ProfesorDTO.class);
		return new ResponseEntity<ProfesorDTO>(pd, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
		Profesor p = profesorService.findOne(id);
		if(p != null) {
			profesorService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
