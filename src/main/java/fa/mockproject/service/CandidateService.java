package fa.mockproject.service;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.DashboardData;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.TraineeCandidateProfileStatus;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface CandidateService {

  public List<Candidate> listAll();


  public void save(Candidate candidate);

  public Candidate findById(long candidateId);

  public void delete(Candidate candidate);

  public void deleteById(long candidateId);

  public List<Candidate> search(@Param("word") String word);

  public Candidate findByTraineeCandidateProfile(TraineeCandidateProfile profile);

  List<DashboardData> findByLocationAndStatus(Location location,
      TraineeCandidateProfileStatus status);
}
