package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Exam;
import projekatTSEO.app.repository.ExamRepository;

@Service
public class ExamService {
	
	@Autowired
	private ExamRepository examRepository;
	
	public Exam findOne(Long id) {
		return examRepository.findById(id).orElse(null);
	}
	
	public List<Exam> findAll() {
		return examRepository.findAll();
	}
	

	public Exam save(Exam ispit) {
		return examRepository.save(ispit);
	}

	public void remove(Long id) {
		examRepository.deleteById(id);
	}

}
