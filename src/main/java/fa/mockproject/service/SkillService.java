package fa.mockproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Skill;
import fa.mockproject.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository repo;

	public List<Skill> ListAll(){
		return (List<Skill>)repo.findAll();
	}
	

}
