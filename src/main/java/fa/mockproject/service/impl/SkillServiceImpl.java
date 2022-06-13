package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Skill;
import fa.mockproject.repository.SkillRepository;
import fa.mockproject.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
	@Autowired
	private SkillRepository repo;

	public List<Skill> listAll() {
		return (List<Skill>) repo.findAll();
	}

	public void save(Skill skill) {
		repo.save(skill);
	}

	public Skill get(String skillId) {
		Optional<Skill> rs = repo.findById(skillId);
		return rs.get();
	}

	public void delete(Skill skill) {
		repo.delete(skill);
	}

	public void deleteById(String skillId) {
		repo.deleteById(skillId);
	}

}

