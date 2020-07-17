package projekatTSEO.app.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekatTSEO.app.model.Ispit;

@Repository
@ComponentScan(basePackages = "projekatTSEO.app.repository")
public interface IspitRepository extends JpaRepository<Ispit, Long> {
	

}
