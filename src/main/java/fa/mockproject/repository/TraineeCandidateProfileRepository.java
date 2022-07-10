package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.TraineeCandidateProfile;

@Repository
public interface TraineeCandidateProfileRepository extends JpaRepository<TraineeCandidateProfile, Long> {

	@Query(value = "SELECT t from TraineeCandidateProfile t where t.fullName LIKE '%' || :word || '%' "
			+ "OR t.email LIKE '%' || :word || '%' " + "OR t.phone LIKE '%' || :word || '%' "
			+ "OR t.dateOfBirth LIKE '%' || :word || '%' " + "OR t.gender LIKE '%' || :word || '%' "
			+ "OR t.foreignLanguage LIKE '%' || :word || '%' " + "OR t.level LIKE '%' || :word || '%'"
			+ "OR t.remarks LIKE '%' || :word || '%'" + "OR t.allocationStatus LIKE '%' || :word || '%'"
			+ "OR t.traineeCandidateProfileId LIKE '%' || :word || '%' ")
	public List<TraineeCandidateProfile> search(@Param("word") String word);

	public TraineeCandidateProfile findByCandidate(Candidate candidateId);
}
