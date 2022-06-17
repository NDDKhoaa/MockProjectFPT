package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{

}
