package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
