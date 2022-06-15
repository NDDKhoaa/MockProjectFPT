package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Candidate;

public interface CandidateService {

	public List<Candidate> listAll();
	

	public void save(Candidate candidate);

	public Candidate findById(long candidateId);

	public void delete(Candidate candidate);

	public void deleteById(long candidateId);

}
