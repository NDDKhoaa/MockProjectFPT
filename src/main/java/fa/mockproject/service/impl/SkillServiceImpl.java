package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Skill;
import fa.mockproject.model.SkillModel;
import fa.mockproject.repository.SkillRepository;
import fa.mockproject.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
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
		return rs.orElse(null);
	}

	public void delete(Skill skill) {
		repo.delete(skill);
	}

	public void deleteById(String skillId) {
		repo.deleteById(skillId);
	}

	@Override
	public List<SkillModel> getAll() {
		return repo.findAll().stream().map(skill -> 
			new SkillModel(skill)).collect(Collectors.toCollection(ArrayList::new));
	}

	public List<Skill> search(@Param("word") String word) {
		return (List<Skill>) repo.search(word);
	}

}
