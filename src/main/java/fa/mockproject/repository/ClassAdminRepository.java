package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.ClassAdmin;

@Repository
public interface ClassAdminRepository extends JpaRepository<ClassAdmin, Long> {

}
