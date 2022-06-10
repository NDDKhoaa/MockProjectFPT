package fa.mockproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.CV;
import fa.mockproject.model.TraineeCandidateProfileModel;
import fa.mockproject.repository.CVRepository;

@Service
public class CVService {
	@Autowired
	private CVRepository repo;
	
	public void save(TraineeCandidateProfileModel model) {
		CV cv = new CV(model);
		repo.save(cv);
	}
}
