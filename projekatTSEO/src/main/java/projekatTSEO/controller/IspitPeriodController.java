package projekatTSEO.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatTSEO.model.Ispit;
import projekatTSEO.model.IspitPeriod;
import projekatTSEO.service.IspitPeriodService;
import projekatTSEO.dto.PredmetDTO;
import projekatTSEO.dto.IspitDTO;
import projekatTSEO.dto.IspitPeriodDTO;
import projekatTSEO.dto.StudentDTO;


@RestController
@RequestMapping(value="api/ispitiPeriod")
public class IspitPeriodController {
	
	@Autowired
	private IspitPeriodService ispitPeriodService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<IspitPeriodDTO>> getAllIspitPeriod() {
		List<IspitPeriod> ispitPeriods = ispitPeriodService.findAll();
		//konvertovanje ispitPerioda u DTO
		List<IspitPeriodDTO> ispitPeriodsDTO = new ArrayList<>();
		for (IspitPeriod s : ispitPeriods) {
			ispitPeriodsDTO.add(new IspitPeriodDTO(s));
		}
		return new ResponseEntity<>(ispitPeriodsDTO, HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IspitPeriodDTO>> getIspitPeriodPage(Pageable page) {
		//page object holds data about pagination and sorting
		//the object is created based on the url parameters "page", "size" and "sort" 
		Page<IspitPeriod> ispitPeriods = ispitPeriodService.findAll(page);
		
		//konvertovanje ispitPerioda u DTO
		List<IspitPeriodDTO> ispitPeriodsDTO = new ArrayList<>();
		for (IspitPeriod s : ispitPeriods) {
			ispitPeriodsDTO.add(new IspitPeriodDTO(s));
		}
		return new ResponseEntity<>(ispitPeriodsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<IspitPeriodDTO> getIspitPeriod(@PathVariable Long id){
		IspitPeriod ispitPeriod = ispitPeriodService.findOne(id);
		if(ispitPeriod == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new IspitPeriodDTO(ispitPeriod), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<IspitPeriodDTO> saveIspitPeriod(@RequestBody IspitPeriodDTO ispitPeriodDTO){
		IspitPeriod ispitPeriod = new IspitPeriod();
		
		ispitPeriod.setNaziv(ispitPeriodDTO.getNaziv());
		ispitPeriod.setPocetakRoka(ispitPeriodDTO.getPocetakRoka());
		ispitPeriod.setKrajRoka(ispitPeriodDTO.getKrajRoka());
		
		ispitPeriod = ispitPeriodService.save(ispitPeriod);
		return new ResponseEntity<>(new IspitPeriodDTO(ispitPeriod), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<IspitPeriodDTO> updateIspitPeriod(@RequestBody IspitPeriodDTO ispitPeriodDTO){
		// ispitPeriod mora postojati
		IspitPeriod ispitPeriod = ispitPeriodService.findOne(ispitPeriodDTO.getId()); 
		if (ispitPeriod == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ispitPeriod.setNaziv(ispitPeriodDTO.getNaziv());
		ispitPeriod.setPocetakRoka(ispitPeriodDTO.getPocetakRoka());
		ispitPeriod.setKrajRoka(ispitPeriodDTO.getKrajRoka());
		
		ispitPeriod = ispitPeriodService.save(ispitPeriod);
		return new ResponseEntity<>(new IspitPeriodDTO(ispitPeriod), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteIspitPeriod(@PathVariable Long id){
		IspitPeriod ispitPeriod = ispitPeriodService.findOne(id);
		if (ispitPeriod != null){
			ispitPeriodService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{ispitPeriodId}/ispiti", method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getIspitPeriodIspiti(
			@PathVariable Long ispitPeriodId) {
		IspitPeriod ispitPeriod = ispitPeriodService.findOne(ispitPeriodId);
		Set<Ispit> ispiti = ispitPeriod.getIspiti();
		List<IspitDTO> ispitiDTO = new ArrayList<>();
		for (Ispit e: ispiti) {
			IspitDTO ispitDTO = new IspitDTO();
			ispitDTO.setId(e.getId());
			ispitDTO.setBrojBodova(e.getBrojBodova());
			ispitDTO.setPObavezeBodovi(e.getPObavezeBodovi());
			ispitDTO.setDate(e.getDatum());
			ispitDTO.setPredmet(new PredmetDTO(e.getPredmet()));
			ispitDTO.setStudent(new StudentDTO(e.getStudent()));
		
			ispitiDTO.add(ispitDTO);
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}

}
