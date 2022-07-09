package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Skill;
import fa.mockproject.model.SkillModel;

public interface SkillService {
	
	public List<Skill> listAll();

	public void save(Skill skill);

	public Skill get(String skillId);

	public void delete(Skill skill);

	public void deleteById(String skillId);
	
	List<SkillModel> getAll();

}
