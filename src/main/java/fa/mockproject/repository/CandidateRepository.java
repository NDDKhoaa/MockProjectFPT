package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	@Query(value = "SELECT c from Candidate c where c.candidateId LIKE '%' || :word || '%' "
			+ "OR c.applicationDate LIKE '%' || :word || '%' " + "OR c.status LIKE '%' || :word || '%' "
			+ "OR c.channel LIKE '%' || :word || '%' " + "OR c.location LIKE '%' || :word || '%' "
			+ "OR c.remarks LIKE '%' || :word || '%' ")
	public List<Candidate> search(@Param("word") String word);
}
