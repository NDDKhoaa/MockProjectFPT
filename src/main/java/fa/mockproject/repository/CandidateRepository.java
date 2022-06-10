package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.TraineeCandidateProfile;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

	void save(TraineeCandidateProfile profile);

}
