package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.CV;
import fa.mockproject.model.TraineeCandidateProfileModel;
import fa.mockproject.repository.CVRepository;
import fa.mockproject.service.CVService;

@Service
public class CVServiceImpl implements CVService {
	@Autowired
	private CVRepository repo;

	public void save(TraineeCandidateProfileModel model) {
		CV cv = new CV(model);
		repo.save(cv);
	}

	public CV getFile(long fileId) {
		Optional<CV> rs = repo.findById(fileId);
		return rs.orElse(null);
	}

	public List<CV> getFiles() {
		return repo.findAll();
	}

	public void delete(CV cv) {
		repo.delete(cv);
	}

	public void deleteById(long cvId) {
		repo.deleteById(cvId);
	}

	public void save(CV cv) {
		repo.save(cv);
	}
}
