package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Student;
import projekatTSEO.app.repository.StudentRepository;
@Service
public class StudentService {
	

	@Autowired
	StudentRepository studentRepository;
	
	public Student findOne(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void remove(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Student findByCard(String brojIndeksa) {
		return studentRepository.findByBrojIndeksa(brojIndeksa);
	}
	
	public List<Student> findByPrezime(String prezime) {
		return studentRepository.findByPrezime(prezime);
	}
	
	public int izracunajOcenu(int poeni) {
		if (poeni < 0 || poeni > 100)
			throw new NumberFormatException();
		
		return poeni < 55 ? 5 : Math.round(poeni/(float) 10);
	}

}
