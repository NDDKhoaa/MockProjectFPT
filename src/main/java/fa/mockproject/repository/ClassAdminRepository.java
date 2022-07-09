package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Budget;
import fa.mockproject.entity.ClassAdmin;
import fa.mockproject.entity.ClassBatch;

@Repository
public interface ClassAdminRepository extends JpaRepository<ClassAdmin, Long> {
	List<ClassAdmin> findClassAdminByClassBatch(ClassBatch classBatch);
}
