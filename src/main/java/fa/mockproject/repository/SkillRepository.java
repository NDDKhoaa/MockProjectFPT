package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, String>{

}
