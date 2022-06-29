package fa.mockproject.repository;

import fa.mockproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByEmail(String user);
     User findByUser(User userId);
}
