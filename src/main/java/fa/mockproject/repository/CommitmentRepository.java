package fa.mockproject.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fa.mockproject.entity.Commitment;

public interface CommitmentRepository extends JpaRepository<Commitment, Long> {
	@Modifying
	@Transactional
	@Query("Update Commitment c Set c.committedValue = :committedValue, c.committedWorkingDuration = :committedWorkingDuration,"
			+ "c.committedWorkingEndDate = :committedWorkingEndDate, c.committedWorkingStartDate = :committedWorkingStartDate,"
			+ "c.remarks = :remarks Where c.commitmentId = :commitmentId")
	void update(@Param("commitmentId") long commitmentId,@Param("committedValue") long committedValue,
			@Param("committedWorkingDuration") Integer committedWorkingDuration,
			@Param("committedWorkingEndDate") LocalDate committedWorkingEndDate, 
			@Param("committedWorkingStartDate") LocalDate committedWorkingStartDate,
			@Param("remarks") String remarks);
}
