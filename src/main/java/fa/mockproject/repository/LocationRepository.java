package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {

	@Query(value = "SELECT f from Location f where f.locationId LIKE '%' || :word || '%' "
			+ "OR f.locationName LIKE '%' || :word || '%' " + "OR f.remarks LIKE '%' || :word || '%' ")
	public List<Location> search(@Param("word") String word);
}
