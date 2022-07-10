package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.repository.CandidateRepository;
import fa.mockproject.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	public List<Candidate> listAll() {
		return (List<Candidate>) candidateRepository.findAll();
	}

	public void save(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	public Candidate findById(long candidateId) {
		Optional<Candidate> rs = candidateRepository.findById(candidateId);
		return rs.orElse(null);
	}

	public void delete(Candidate candidate) {
		candidateRepository.delete(candidate);
	}

	public void deleteById(long candidateId) {
		candidateRepository.deleteById(candidateId);
	}

	public List<Candidate> search(@Param("word") String word) {
		return (List<Candidate>) candidateRepository.search(word);
	}
	
	public Candidate findByTraineeCandidateProfile(TraineeCandidateProfile profile) {
		Candidate rs = candidateRepository.findByTraineeCandidateProfile(profile);
		return rs;
	}
}
