package fa.mockproject.repository;

import fa.mockproject.entity.Role;
import fa.mockproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
