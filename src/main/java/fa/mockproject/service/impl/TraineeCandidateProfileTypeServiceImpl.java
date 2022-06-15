package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.TraineeCandidateProfileType;
import fa.mockproject.repository.TraineeCandidateProfileTypeRepository;
import fa.mockproject.service.TraineeCandidateProfileTypeService;

@Service
public class TraineeCandidateProfileTypeServiceImpl implements TraineeCandidateProfileTypeService {
	@Autowired
	private TraineeCandidateProfileTypeRepository repo;

	public List<TraineeCandidateProfileType> listAll() {
		return (List<TraineeCandidateProfileType>) repo.findAll();
	}

	public void save(TraineeCandidateProfileType type) {
		repo.save(type);
	}

	public TraineeCandidateProfileType findById(String typeId) {
		Optional<TraineeCandidateProfileType> rs = repo.findById(typeId);
		return rs.get();
	}

	public void delete(TraineeCandidateProfileType type) {
		repo.delete(type);
	}

	public void deleteById(String typeId) {
		repo.deleteById(typeId);
	}
	
}
