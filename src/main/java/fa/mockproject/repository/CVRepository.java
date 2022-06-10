package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Long>{

		@Query("SELECT new CV(c.cvId,c.name) FROM CV c where c.name LIKE :name")
		List<CV> findByName(@Param("name") String name);
}
