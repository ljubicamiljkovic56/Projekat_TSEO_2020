package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Uplata;
import projekatTSEO.app.repository.UplataRepository;

@Service
public class UplataService {

	@Autowired
	UplataRepository uplataRepository;
	
	public Uplata findOne(Long id) {
		return uplataRepository.findById(id).orElse(null);
	}

	public List<Uplata> findAll() {
		return uplataRepository.findAll();
	}
	
	public Page<Uplata> findAll(Pageable page) {
		return uplataRepository.findAll(page);
	}

	public Uplata save(Uplata uplata) {
		return uplataRepository.save(uplata);
	}

	public void remove(Long id) {
		uplataRepository.deleteById(id);
	}
}

