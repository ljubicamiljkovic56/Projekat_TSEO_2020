package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.PohadjanjePredmeta;
import projekatTSEO.app.model.Predmet;
import projekatTSEO.app.model.Profesor;
import projekatTSEO.app.model.Student;
import projekatTSEO.app.repository.PohadjanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {

	@Autowired
	PohadjanjePredmetaRepository pohadjanjePredmetaRepository;
	
	public List<PohadjanjePredmeta> findAll(){
		return pohadjanjePredmetaRepository.findAll();
	}
	
	public Page<PohadjanjePredmeta> findAll(Pageable page){
		return pohadjanjePredmetaRepository.findAll(page);
	}
	
	public PohadjanjePredmeta findOne(Long id) {
		return pohadjanjePredmetaRepository.findById(id).orElse(null);
	}
	
	public List<PohadjanjePredmeta> findByStudent(Student s){
		return pohadjanjePredmetaRepository.findByStudent(s);
	}
	
	public List<PohadjanjePredmeta> findByProfesor(Profesor s){
		return pohadjanjePredmetaRepository.findByProfesor(s);
	}
	
	public List<PohadjanjePredmeta> findByPredmet(Predmet s){
		return pohadjanjePredmetaRepository.findByPredmet(s);
	}
	
	public PohadjanjePredmeta save(PohadjanjePredmeta p) {
		return pohadjanjePredmetaRepository.save(p);
	}
	
	public void remove(Long id) {
		pohadjanjePredmetaRepository.deleteById(id);;
	}
	
}
