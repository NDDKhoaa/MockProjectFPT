package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Faculty;
import fa.mockproject.repository.FacultyRepository;
import fa.mockproject.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{
	@Autowired
	private FacultyRepository repo;

	public List<Faculty> listAll() {
		return (List<Faculty>) repo.findAll();
	}

	public void save(Faculty faculty) {
		repo.save(faculty);
	}

	public Faculty findById(String facultyId) {
		Optional<Faculty> location = repo.findById(facultyId);
		return location.get();
	}

	public void delete(Faculty faculty) {
		repo.delete(faculty);
	}

	public void deleteById(String facultyId) {
		repo.deleteById(facultyId);
	}

	public List<Faculty> search(@Param("word") String word) {
		return (List<Faculty>) repo.search(word);
	}
}
