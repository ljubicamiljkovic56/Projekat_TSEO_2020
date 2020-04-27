package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.model.Predmet;
import projekatTSEO.repository.PredmetRepository;


@Service
public class PredmetService {

	@Autowired
	PredmetRepository predmetRepository;
	
	public Predmet findOne(Long id) {
		return predmetRepository.findById(id).orElse(null);
	}

	public List<Predmet> findAll() {
		return predmetRepository.findAll();
	}
	
	public Page<Predmet> findAll(Pageable page) {
		return predmetRepository.findAll(page);
	}

	public Predmet save(Predmet predmet) {
		return predmetRepository.save(predmet);
	}

	public void remove(Long id) {
		predmetRepository.deleteById(id);
	}
}
