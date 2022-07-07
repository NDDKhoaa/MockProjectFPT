package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.InterviewValuation;

@Repository
public interface InterviewValuationRepository extends JpaRepository<InterviewValuation, Long> {

	
}
