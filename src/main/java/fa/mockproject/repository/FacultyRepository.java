package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, String> {

	@Query(value = "SELECT f from Faculty f where f.facultyId LIKE '%' || :word || '%' "
			+ "OR f.facultyName LIKE '%' || :word || '%' " + "OR f.remarks LIKE '%' || :word || '%' ")
	public List<Faculty> search(@Param("word") String word);
}
