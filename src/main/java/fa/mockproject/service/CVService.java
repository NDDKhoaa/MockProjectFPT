package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.CV;
import fa.mockproject.model.TraineeCandidateProfileModel;

public interface CVService {
	
	public void save(CV cv);

	public void save(TraineeCandidateProfileModel model);

	public CV getFile(long fileId);

	public List<CV> getFiles();

	public void deleteById(long cvId);

	public void delete(CV cv);
}
