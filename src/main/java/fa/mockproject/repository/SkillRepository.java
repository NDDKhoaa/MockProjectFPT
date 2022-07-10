package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{

	@Query(value = "SELECT f from Skill f where f.skillId LIKE '%' || :word || '%' "
			+ "OR f.skillName LIKE '%' || :word || '%' " + "OR f.remarks LIKE '%' || :word || '%' ")
	public List<Skill> search(@Param("word") String word);
}
