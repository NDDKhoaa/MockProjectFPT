package fa.mockproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
	
	Trainee findByTraineeCandidateId(long id);
	
	
	Page<Trainee> findAll(Pageable pageable);
	
}
