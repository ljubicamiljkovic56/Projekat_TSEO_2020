package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.model.Profesor;
import projekatTSEO.repository.ProfesorRepository;


@Service
public class ProfesorService {

	
	@Autowired
	ProfesorRepository profesorRepository;
	
	public Profesor findOne(int id) {
		return profesorRepository.findById(id).orElse(null);
	}

	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}
	
	public Page<Profesor> findAll(Pageable page) {
		return profesorRepository.findAll(page);
	}

	public Profesor save(Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	public void remove(int id) {
		profesorRepository.deleteById(id);
	}
}
