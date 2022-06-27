package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.EntryTest;

public interface EntryTestService {

	public List<EntryTest> listAll();

	public void save(EntryTest entryTest);

	public EntryTest findById(long entryTestId);

	public void delete(EntryTest entryTest);

	public void deleteById(long entryTestId);

	public List<EntryTest> findByCandidate(Candidate candidate);
}