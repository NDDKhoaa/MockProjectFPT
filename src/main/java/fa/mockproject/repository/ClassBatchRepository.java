package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;

@Repository
@Transactional
public interface ClassBatchRepository extends JpaRepository<ClassBatch, Long>, JpaSpecificationExecutor<ClassBatch> {
	
	@Procedure(name = "ClassBatch.updateStatus")
	int updateStatus(@Param("class_id") Long classId,
			@Param("status") String classBatchStatus,
			@Param("history") String history,
			@Param("remarks") String remarks);
	
	@Query("SELECT c.status FROM ClassBatch c WHERE c.classId = ?1")
	ClassBatchStatusEnum findStatusByClassId(Long classId);
	
	@Query("SELECT DISTINCT c.className FROM ClassBatch c")
	List<String> findAllClassName();
	
	@Query("SELECT c.weightedNumber FROM ClassBatch c WHERE c.classId = ?1")
	String findWeightedNumber(Long classId);
	
	@Query("SELECT c.trainees FROM ClassBatch c WHERE c.classId = ?1")
	List<Trainee> findTraineeByClassId(Long classId);
	
	@Query("SELECT c.trainees FROM ClassBatch c WHERE c.classId = ?1")
	Page<Trainee> findTraineeByClassId(Long classId, Pageable pageable);

    List<ClassBatch> findByLocationAndStatus(Location location, ClassBatchStatusEnum status);
    List<ClassBatch> findByLocation(Location location);
    List<ClassBatch> findByStatus(ClassBatchStatusEnum status);
}
