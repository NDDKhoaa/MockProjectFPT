package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Faculty;
import fa.mockproject.repository.FacultyRepository;

@Service
public class FacultyServiceImpl {
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
}
