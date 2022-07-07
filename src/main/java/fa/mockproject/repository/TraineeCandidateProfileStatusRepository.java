package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.TraineeCandidateProfileStatus;

@Repository
public interface TraineeCandidateProfileStatusRepository extends JpaRepository<TraineeCandidateProfileStatus, String> {
	@Query(value = "SELECT t from TraineeCandidateProfileStatus t where t.profileStatusId LIKE '%' || :word || '%' "
			+ "OR t.status LIKE '%' || :word || '%' ")
	public List<TraineeCandidateProfileStatus> search(@Param("word") String word);
	
}