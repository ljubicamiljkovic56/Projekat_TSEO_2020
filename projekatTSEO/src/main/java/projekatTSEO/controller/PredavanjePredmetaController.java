//package projekatTSEO.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import projekatTSEO.service.TeachingService;
//
//@RestController
//@RequestMapping(value = "api/teaching")
//public class PredavanjePredmetaController {
//
//	
//	@Autowired
//	private TeachingService pPService;
//	
//	@Autowired
//	public ModelMapper mapper;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<TeachingDTO>> getPredavanja(){
//		List<CourseTeachers> predavanja = pPService.findAll();
//		List<TeachingDTO> predavanjaDTO = new ArrayList<>();
//		TeachingDTO pDTO;
//		for(CourseTeachers p : predavanja) {
//			pDTO = mapper.map(p, TeachingDTO.class);
//			predavanjaDTO.add(pDTO);
//		}
//		return new ResponseEntity<List<TeachingDTO>>(predavanjaDTO, HttpStatus.OK);
//	}
//	
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<TeachingDTO> getOne(@PathVariable Long id){
//		CourseTeachers predavanje = pPService.findOne(id);
//		if(predavanje == null)
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		TeachingDTO pDTO = mapper.map(predavanje, TeachingDTO.class);
//		return new ResponseEntity<TeachingDTO>(pDTO, HttpStatus.OK);
//	}
//	
//	
//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//	public ResponseEntity<TeachingDTO> savePredavanje(@RequestBody TeachingDTO pp) {
//		CourseTeachers predavanje = mapper.map(pp, CourseTeachers.class);
//		CourseTeachers novo = pPService.save(predavanje);
//		TeachingDTO pDTO = mapper.map(novo, TeachingDTO.class); //pp
//		return new ResponseEntity<TeachingDTO>(pDTO, HttpStatus.CREATED);
//	}
//	
//	
//	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
//	public ResponseEntity<TeachingDTO> updatePredavanje(@RequestBody TeachingDTO pp){
//		CourseTeachers predavanje = mapper.map(pp, CourseTeachers.class);
//		if(pPService.findOne(predavanje.getId())==null)
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		predavanje = pPService.save(predavanje);
//		TeachingDTO pDTO = mapper.map(predavanje, TeachingDTO.class);
//		return new ResponseEntity<TeachingDTO>(pDTO, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> deletePredavanje(@PathVariable Long id){
//		CourseTeachers predavanje = pPService.findOne(id);
//		if(predavanje != null) {
//			pPService.remove(id);
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		}else {
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}
//		
//	}
//	
//	
//	
//}
