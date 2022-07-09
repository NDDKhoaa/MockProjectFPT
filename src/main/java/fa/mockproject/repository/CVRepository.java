package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Long> {

	@Query(value = "SELECT c from CV c where c.cvId LIKE '%' || :word || '%' " + "OR c.size LIKE '%' || :word || '%' "
			+ "OR c.name LIKE '%' || :word || '%' ")
	public List<CV> search(@Param("word") String word);
}
