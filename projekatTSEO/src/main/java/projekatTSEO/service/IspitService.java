package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatTSEO.model.Ispit;
import projekatTSEO.repository.IspitRepository;

@Service
public class IspitService {
	
	@Autowired
	IspitRepository ispitRepository;
	
	public Ispit findOne(int id) {
		return ispitRepository.findById(id).orElse(null);
	}
	
	public List<Ispit> findAll() {
		return ispitRepository.findAll();
	}
	

	public Ispit save(Ispit ispit) {
		return ispitRepository.save(ispit);
	}

	public void remove(int id) {
		ispitRepository.deleteById(id);
	}

}
