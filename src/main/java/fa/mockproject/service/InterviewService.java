package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Interview;

public interface InterviewService {

	public List<Interview> listAll();

	public void save(Interview inteview);

	public Interview findById(long inteviewId);

	public void delete(Interview inteview);

	public void deleteById(long inteviewId);

	public List<Interview> findByCandidate(Candidate candidate);
}