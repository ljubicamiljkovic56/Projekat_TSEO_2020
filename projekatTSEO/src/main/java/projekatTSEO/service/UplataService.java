package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.model.Uplata;
import projekatTSEO.repository.UplataRepository;

@Service
public class UplataService {

	@Autowired
	UplataRepository uplataRepository;
	
	public Uplata findOne(int id) {
		return uplataRepository.findById(id);
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

	public void remove(int id) {
		uplataRepository.deleteById(id);
	}
}

