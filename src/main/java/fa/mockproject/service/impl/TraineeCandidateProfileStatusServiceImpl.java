package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.TraineeCandidateProfileStatus;
import fa.mockproject.repository.TraineeCandidateProfileStatusRepository;
import fa.mockproject.service.TraineeCandidateProfileStatusService;

@Service
public class TraineeCandidateProfileStatusServiceImpl implements TraineeCandidateProfileStatusService {
	@Autowired
	private TraineeCandidateProfileStatusRepository repo;

	public List<TraineeCandidateProfileStatus> listAll() {
		return (List<TraineeCandidateProfileStatus>) repo.findAll();
	}

	public void save(TraineeCandidateProfileStatus status) {
		repo.save(status);
	}

	public TraineeCandidateProfileStatus findById(String statusId) {
		Optional<TraineeCandidateProfileStatus> rs = repo.findById(statusId);
		return rs.get();
	}

	public void delete(TraineeCandidateProfileStatus status) {
		repo.delete(status);
	}

	public void deleteById(String statusId) {
		repo.deleteById(statusId);
	}
	
}
