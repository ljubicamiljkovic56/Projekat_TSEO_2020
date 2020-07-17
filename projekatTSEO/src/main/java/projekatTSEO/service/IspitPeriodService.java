package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.IspitPeriod;
import projekatTSEO.app.repository.IspitPeriodRepository; 

@Service
public class IspitPeriodService {
	@Autowired
	IspitPeriodRepository ispitPeriodRepository;
	
	public IspitPeriod findOne(Long id) {
		return ispitPeriodRepository.findById(id).orElse(null);
	}

	public List<IspitPeriod> findAll() {
		return ispitPeriodRepository.findAll();
	}
	
	public Page<IspitPeriod> findAll(Pageable page) {
		return ispitPeriodRepository.findAll(page);
	}

	public IspitPeriod save(IspitPeriod ispitPeriod) {
		return ispitPeriodRepository.save(ispitPeriod);
	}

	public void remove(Long id) {
		ispitPeriodRepository.deleteById(id);
	}
	

}
