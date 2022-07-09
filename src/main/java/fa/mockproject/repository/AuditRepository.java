package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Audit;
import fa.mockproject.entity.ClassBatch;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
	List<Audit> findAuditByClassBatch(ClassBatch classBatch);
}
