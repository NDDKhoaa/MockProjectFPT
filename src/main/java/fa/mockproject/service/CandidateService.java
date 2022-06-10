package fa.mockproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.repository.CandidateRepository;

@Service
public class CandidateService {
	@Autowired
	private CandidateRepository repo;
	
}
