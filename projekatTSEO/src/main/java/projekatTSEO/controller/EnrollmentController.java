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

import projekatTSEO.app.model.Enrollment;
import projekatTSEO.dto.EnrollmentDTO;
import projekatTSEO.service.EnrollmentService;

@RestController
@RequestMapping(value = "/api/enrollments")
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentS;
	
	@Autowired
	private ModelMapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EnrollmentDTO>> getEnrollments(){
		List<Enrollment> enrollments = enrollmentS.findAll();
		List<EnrollmentDTO> eDTO = new ArrayList<EnrollmentDTO>();
		EnrollmentDTO edto;
		for(Enrollment e : enrollments) {
			edto = mapper.map(e, EnrollmentDTO.class);
			eDTO.add(edto);
		}
		return new ResponseEntity<List<EnrollmentDTO>>(eDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EnrollmentDTO> getOne(@PathVariable Long id){
		Enrollment e = enrollmentS.findOne(id);
		EnrollmentDTO eDTO;
		if(e == null)
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.NOT_FOUND);
		eDTO = mapper.map(e, EnrollmentDTO.class);
		return new ResponseEntity<EnrollmentDTO>(eDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<EnrollmentDTO> save(@RequestBody EnrollmentDTO eDTO){
		Enrollment e = mapper.map(eDTO, Enrollment.class);
		enrollmentS.save(e);
		return new ResponseEntity<EnrollmentDTO>(eDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<EnrollmentDTO> update(@RequestBody EnrollmentDTO eDTO){
		Enrollment e = mapper.map(eDTO, Enrollment.class);
		EnrollmentDTO edto;
		if(enrollmentS.findOne(e.getId()) == null) {			
			return new ResponseEntity<EnrollmentDTO>(HttpStatus.BAD_REQUEST);
		}
		e = enrollmentS.save(e);
		edto = mapper.map(e, EnrollmentDTO.class);
		return new ResponseEntity<EnrollmentDTO>(edto, HttpStatus.OK);			
	}
	
	
	@RequestMapping(value = "/id", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Enrollment e = enrollmentS.findOne(id);
		if(e != null) {
			enrollmentS.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
}
