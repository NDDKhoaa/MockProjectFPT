package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.repository.TraineeCandidateProfileRepository;
import fa.mockproject.service.TraineeCandidateProfileService;

@Service
public class TraineeCandidateProfileServiceImpl implements TraineeCandidateProfileService {
	@Autowired
	private TraineeCandidateProfileRepository repo;

	public List<TraineeCandidateProfile> listAll() {
		return (List<TraineeCandidateProfile>) repo.findAll();
	}

	public void save(TraineeCandidateProfile profile) {
		repo.save(profile);
	}

	public TraineeCandidateProfile findById(long profileId) {
		Optional<TraineeCandidateProfile> rs = repo.findById(profileId);
		return rs.get();
	}

	public void delete(TraineeCandidateProfile profile) {
		repo.delete(profile);
	}

	public void deleteById(long profileId) {
		repo.deleteById(profileId);
	}
	
}
