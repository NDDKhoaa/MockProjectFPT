package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.EntryTest;

@Repository
public interface EntryTestRepository extends JpaRepository<EntryTest, Long>{

	public List<EntryTest> findByCandidate(Candidate candidate);
}
