package ua.repository;

import ua.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
//	@Query("SELECT true from User u WHERE u.email=?1")
//	boolean extistsByEmail(String email);
}
