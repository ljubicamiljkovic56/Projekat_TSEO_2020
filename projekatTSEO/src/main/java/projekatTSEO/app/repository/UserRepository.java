package projekatTSEO.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekatTSEO.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
