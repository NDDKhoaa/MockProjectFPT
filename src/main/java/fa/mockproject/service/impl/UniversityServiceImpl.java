package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.University;
import fa.mockproject.repository.UniversityRepository;
import fa.mockproject.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	UniversityRepository repo;

	public List<University> listAll() {
		return (List<University>) repo.findAll();
	}

	public void save(University university) {
		repo.save(university);
	}

	public University get(String universityId) {
		Optional<University> rs = repo.findById(universityId);
		return rs.get();
	}

	public void delete(University university) {
		repo.delete(university);
	}

	public void deleteById(String universityId) {
		repo.deleteById(universityId);
	}

	public List<University> search(@Param("word") String word) {
		return (List<University>) repo.search(word);
	}
}
