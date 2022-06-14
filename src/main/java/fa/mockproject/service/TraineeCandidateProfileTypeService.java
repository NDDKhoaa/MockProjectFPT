package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.TraineeCandidateProfileType;

public interface TraineeCandidateProfileTypeService {
	public List<TraineeCandidateProfileType> listAll();

	public void save(TraineeCandidateProfileType profile);

	public TraineeCandidateProfileType findById(String typeId);

	public void delete(TraineeCandidateProfileType profile);

	public void deleteById(String typeId);
}
