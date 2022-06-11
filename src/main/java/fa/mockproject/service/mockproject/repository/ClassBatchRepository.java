package fa.mockproject.service.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.ClassBatch;

@Repository
public interface ClassBatchRepository extends JpaRepository<ClassBatch, Long> {

}
