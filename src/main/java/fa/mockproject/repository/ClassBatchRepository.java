package fa.mockproject.repository;

import fa.mockproject.entity.Location;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;

import java.util.List;

@Repository
public interface ClassBatchRepository extends JpaRepository<ClassBatch, Long> {
    List<ClassBatch> findByLocationAndStatus(Location location, ClassBatchStatusEnum status);
    List<ClassBatch> findByLocation(Location location);
    List<ClassBatch> findByStatus(ClassBatchStatusEnum status);

	void save(ClassBatchStatusEnum plannedstatus);

}
