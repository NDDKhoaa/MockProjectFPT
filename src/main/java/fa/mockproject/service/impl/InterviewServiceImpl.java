package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.Interview;
import fa.mockproject.repository.InterviewRepository;
import fa.mockproject.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService{
	@Autowired
	private InterviewRepository repo;

	public List<Interview> listAll() {
		return (List<Interview>) repo.findAll();
	}

	public void save(Interview interview) {
		repo.save(interview);
	}

	public Interview findById(long interviewId) {
		Optional<Interview> interview = repo.findById(interviewId);
		return interview.get();
	}

	public void delete(Interview interview) {
		repo.delete(interview);
	}

	public void deleteById(long interviewId) {
		repo.deleteById(interviewId);
	}

	public List<Interview> findByCandidate(Candidate candidate) {
		return (List<Interview>) repo.findByCandidate(candidate);
	}
}
