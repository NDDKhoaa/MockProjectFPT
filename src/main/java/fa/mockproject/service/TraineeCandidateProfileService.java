package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.TraineeCandidateProfile;

public interface TraineeCandidateProfileService {
	
	public List<TraineeCandidateProfile> listAll();

	public void save(TraineeCandidateProfile profile);

	public TraineeCandidateProfile findById(long profileId);

	public void delete(TraineeCandidateProfile profile);

	public void deleteById(long profileId);
}
