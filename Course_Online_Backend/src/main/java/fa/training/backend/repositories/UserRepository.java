package fa.training.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import fa.training.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.email = :searchKey OR u.phone = :searchKey")
	User findByEmailOrPhone(String searchKey);

	@Query("select u.id from User u where u.email = ?1 or u.phone = ?2")
	public List<Integer> checkExistUserEmailorPhone(String email, String phone);
	Optional<User> findById(int id);
}
