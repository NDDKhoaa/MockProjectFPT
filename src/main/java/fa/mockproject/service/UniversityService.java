package fa.mockproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.University;
import fa.mockproject.repository.UniversityRepository;

@Service
public class UniversityService {

	@Autowired
	UniversityRepository repo;
	
	public List<University> ListAll(){
		return (List<University>)repo.findAll();
	}
	

}
