package projekatTSEO.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	//Uplata findById (Long id);
	
	List<Payment> findAll();

}
