package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.EntryTest;
import fa.mockproject.repository.EntryTestRepository;
import fa.mockproject.service.EntryTestService;

@Service
public class EntryTestServiceImpl implements EntryTestService {
	@Autowired
	private EntryTestRepository repo;

	public List<EntryTest> listAll() {
		return (List<EntryTest>) repo.findAll();
	}

	public void save(EntryTest entryTest) {
		repo.save(entryTest);
	}

	public EntryTest findById(long entryTestId) {
		Optional<EntryTest> location = repo.findById(entryTestId);
		return location.get();
	}

	public void delete(EntryTest entryTest) {
		repo.delete(entryTest);
	}

	public void deleteById(long entryTestId) {
		repo.deleteById(entryTestId);
	}

	public List<EntryTest> findByCandidate(Candidate candidate) {
		return (List<EntryTest>) repo.findByCandidate(candidate);
	}
}
