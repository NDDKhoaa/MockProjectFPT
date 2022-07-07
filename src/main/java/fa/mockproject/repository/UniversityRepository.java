package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, String>{
	
	@Query(value = "SELECT u from University u where u.universityId LIKE '%' || :word || '%' "
			+ "OR u.universityName LIKE '%' || :word || '%' " + "OR u.remarks LIKE '%' || :word || '%' ")
	public List<University> search(@Param("word") String word);
}