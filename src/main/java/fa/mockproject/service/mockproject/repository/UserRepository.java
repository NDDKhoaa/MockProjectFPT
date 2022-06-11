package fa.mockproject.service.mockproject.repository;

import fa.mockproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByUser(String user);
}
