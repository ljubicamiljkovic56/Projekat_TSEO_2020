package projekatTSEO.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import projekatTSEO.model.Ispit;
import projekatTSEO.model.IspitPeriod;
import projekatTSEO.model.Predmet;
import projekatTSEO.model.Student;
import projekatTSEO.service.IspitService;
import projekatTSEO.service.IspitPeriodService;
import projekatTSEO.dto.IspitDTO;

import projekatTSEO.service.StudentService;
import projekatTSEO.service.PredmetService;

@RestController
@RequestMapping(value = "/api/ispiti")
public class IspitController {
	
	@Autowired
	private IspitService ispitService;

	@Autowired
	StudentService studentService;

	@Autowired
	PredmetService predmetService;

	@Autowired
	IspitPeriodService ispitPeriodService;
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<IspitDTO> createIspit(@RequestBody IspitDTO ispitDTO) {
		// ispit mora imati studente predmet i period
		if (ispitDTO.getStudent() == null || ispitDTO.getPredmet() == null
				|| ispitDTO.getIspitPeriod() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(ispitDTO.getStudent().getId());
		Predmet predmet = predmetService.findOne(ispitDTO.getPredmet().getId());
		IspitPeriod ispitPeriod = ispitPeriodService.findOne(ispitDTO
				.getIspitPeriod().getId());
		if (student == null || predmet == null || ispitPeriod == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Ispit ispit = new Ispit();
		ispit.setDatum(ispitDTO.getDatum());
		ispit.setBrojBodova(ispitDTO.getBrojBodova());
		ispit.setPObavezeBodovi(ispitDTO.getPObavezeBodovi());
		ispit.setStudent(student);
		ispit.setPredmet(predmet);
		ispit.setIspitPeriod(ispitPeriod);

		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(new IspitDTO(ispit), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<IspitDTO> updateIspit(@RequestBody IspitDTO ispitDTO) {
		// provara postojanja ispita
		Ispit ispit = ispitService.findOne(ispitDTO.getId());
		if (ispit == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// promena datuma i bodova na ispitu
		ispit.setDatum(ispitDTO.getDatum());
		ispit.setBrojBodova(ispitDTO.getBrojBodova());
		ispit.setPObavezeBodovi(ispitDTO.getPObavezeBodovi());

		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(new IspitDTO(ispit), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteIspit(@PathVariable Long id) {
		Ispit ispit = ispitService.findOne(id);
		if (ispit != null) {
			ispitService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
