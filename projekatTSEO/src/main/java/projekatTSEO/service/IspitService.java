package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Ispit;
import projekatTSEO.app.repository.IspitRepository;

@Service
public class IspitService {
	
	@Autowired
	private IspitRepository ispitRepository;
	
	public Ispit findOne(Long id) {
		return ispitRepository.findById(id).orElse(null);
	}
	
	public List<Ispit> findAll() {
		return ispitRepository.findAll();
	}
	

	public Ispit save(Ispit ispit) {
		return ispitRepository.save(ispit);
	}

	public void remove(Long id) {
		ispitRepository.deleteById(id);
	}

}
