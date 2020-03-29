package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.model.PohadjanjePredmeta;
import projekatTSEO.model.Predmet;
import projekatTSEO.model.Profesor;
import projekatTSEO.model.Student;
import projekatTSEO.repository.PohadjanjePredmetaRepository;

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
	
	public PohadjanjePredmeta findOne(int id) {
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
	
	public void remove(int id) {
		pohadjanjePredmetaRepository.deleteById(id);;
	}
	
}
