package fa.mockproject.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.University;

public interface UniversityService {

	public List<University> listAll();

	public void save(University university);

	public University get(String universityId);

	public void delete(University university);

	public void deleteById(String universityId);

	public List<University> search(@Param("word") String word);
}
