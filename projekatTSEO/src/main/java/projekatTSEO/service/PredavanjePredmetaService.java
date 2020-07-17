package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.PredavanjePredmeta;
import projekatTSEO.app.model.Profesor;
import projekatTSEO.app.repository.PredavanjePredmetaRepository;

@Service
public class PredavanjePredmetaService {

	@Autowired
	PredavanjePredmetaRepository predavanjePredmetaRepository;
	
	public PredavanjePredmeta findOne(Long id) {
		return predavanjePredmetaRepository.findById(id).orElse(null);
	}
	
	public List<PredavanjePredmeta> findAll(){
		return predavanjePredmetaRepository.findAll();
	}
	
	public Page<PredavanjePredmeta> findAll(Pageable page){
		return predavanjePredmetaRepository.findAll(page);
	}
	
	public PredavanjePredmeta save(PredavanjePredmeta pp) {
		return predavanjePredmetaRepository.save(pp);
	}
	
	public void remove(Long id) {
		predavanjePredmetaRepository.deleteById(id);
	}
	
	public List<PredavanjePredmeta> findByProfesor(Profesor profesor){
		return predavanjePredmetaRepository.findByProfesor(profesor);
	}
	
	
}
