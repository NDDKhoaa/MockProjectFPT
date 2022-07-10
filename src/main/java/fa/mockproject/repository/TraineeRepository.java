package fa.mockproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
	
	Trainee findByTraineeCandidateId(long id);
	
	
	Page<Trainee> findAll(Pageable pageable);
	
	@Modifying
	@Transactional
	@Query("delete from Trainee t Where t.traineeCandidateId = :traineeId")
	void deleteTraineeById(@Param("traineeId") long traineeId);
}
