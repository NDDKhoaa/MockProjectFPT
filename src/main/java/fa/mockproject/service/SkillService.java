package fa.mockproject.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.Skill;

public interface SkillService {
	
	public List<Skill> listAll();

	public void save(Skill skill);

	public Skill get(String skillId);

	public void delete(Skill skill);

	public void deleteById(String skillId);

	public List<Skill> search(@Param("word") String word);
}
