package projekatTSEO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projekatTSEO.app.model.Payment;
import projekatTSEO.app.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment findOne(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}

	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}
	
	public Page<Payment> findAll(Pageable page) {
		return paymentRepository.findAll(page);
	}

	public Payment save(Payment uplata) {
		return paymentRepository.save(uplata);
	}

	public void remove(Long id) {
		paymentRepository.deleteById(id);
	}
}

