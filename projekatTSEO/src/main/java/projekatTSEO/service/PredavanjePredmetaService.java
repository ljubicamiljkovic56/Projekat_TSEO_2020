package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.model.PredavanjePredmeta;
import projekatTSEO.model.Profesor;
import projekatTSEO.repository.PredavanjePredmetaRepository;

@Service
public class PredavanjePredmetaService {

	@Autowired
	PredavanjePredmetaRepository predavanjePredmetaRepository;
	
	public PredavanjePredmeta findOne(int id) {
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
	
	public void remove(int id) {
		predavanjePredmetaRepository.deleteById(id);
	}
	
	public List<PredavanjePredmeta> findByProfesor(Profesor profesor){
		return predavanjePredmetaRepository.findByProfesor(profesor);
	}
	
	
}
