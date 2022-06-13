package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.University;

public interface UniversityService {

	public List<University> listAll();

	public void save(University university);

	public University get(String universityId);

	public void delete(University university);

	public void deleteById(String universityId);

}
