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

import projekatTSEO.app.model.Teacher;
import projekatTSEO.dto.TeacherDTO;
import projekatTSEO.service.TeacherService;

@RestController
@RequestMapping(value = "/api/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	public ModelMapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TeacherDTO>> getTeachers(){
		List<TeacherDTO> teachersDTO = new ArrayList<TeacherDTO>();
		TeacherDTO tDTO;
		List<Teacher> teachers = teacherService.findAll();
		for(Teacher p : teachers) {
			tDTO = mapper.map(p, TeacherDTO.class);
			teachersDTO.add(tDTO);
		}		
		return new ResponseEntity<List<TeacherDTO>>(teachersDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Long id){
		Teacher p = teacherService.findOne(id);
		if(p == null)
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		TeacherDTO pDTO = mapper.map(p, TeacherDTO.class);
		return new ResponseEntity<TeacherDTO>(pDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO pDTO){
		Teacher p = mapper.map(pDTO, Teacher.class);
		Teacher novi = teacherService.save(p);
		TeacherDTO pd = mapper.map(novi, TeacherDTO.class); //nisam sigurna da li mi ovo zapravo treba ili sam mogla samo da ostavim pDTO
		return new ResponseEntity<TeacherDTO>(pd, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO pDTO){
		Teacher p = mapper.map(pDTO, Teacher.class);
		if(teacherService.findOne(p.getId()) == null)
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		TeacherDTO pd = mapper.map(p, TeacherDTO.class);
		return new ResponseEntity<TeacherDTO>(pd, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
		Teacher p = teacherService.findOne(id);
		if(p != null) {
			teacherService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
