package fa.mockproject.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.TraineeCandidateProfile;

public interface TraineeCandidateProfileService {
	
	public List<TraineeCandidateProfile> listAll();

	public void save(TraineeCandidateProfile profile);

	public TraineeCandidateProfile findById(long profileId);

	public void delete(TraineeCandidateProfile profile);

	public void deleteById(long profileId);
	
	public List<TraineeCandidateProfile> search(@Param("word") String word);
	
	public TraineeCandidateProfile findByCandidate(Candidate candidateId);
}
