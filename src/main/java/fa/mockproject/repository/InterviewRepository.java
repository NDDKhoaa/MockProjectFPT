package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
	public List<Interview> findByCandidate(Candidate candidate);
}
