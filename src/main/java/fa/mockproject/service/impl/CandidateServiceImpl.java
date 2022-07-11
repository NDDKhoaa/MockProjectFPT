package fa.mockproject.service.impl;

import fa.mockproject.entity.Candidate;
import fa.mockproject.entity.DashboardData;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.TraineeCandidateProfileStatus;
import fa.mockproject.repository.CandidateRepository;
import fa.mockproject.service.CandidateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

  @Autowired
  private CandidateRepository candidateRepository;

  public List<Candidate> listAll() {
    return (List<Candidate>) candidateRepository.findAll();
  }

  public void save(Candidate candidate) {
    candidateRepository.save(candidate);
  }

  public Candidate findById(long candidateId) {
    Optional<Candidate> rs = candidateRepository.findById(candidateId);
    return rs.orElse(null);
  }

  public void delete(Candidate candidate) {
    candidateRepository.delete(candidate);
  }

  public void deleteById(long candidateId) {
    candidateRepository.deleteById(candidateId);
  }

  public List<Candidate> search(@Param("word") String word) {
    return (List<Candidate>) candidateRepository.search(word);
  }

  public Candidate findByTraineeCandidateProfile(TraineeCandidateProfile profile) {
    Candidate rs = candidateRepository.findByTraineeCandidateProfile(profile);
    return rs;
  }

  @Override
  public List<DashboardData> findByLocationAndStatus(Location location, TraineeCandidateProfileStatus status) {
   List<Candidate> candidates = candidateRepository.findByLocationAndStatus(location, status);
    Map<String, Integer> stringIntegerMap = new HashMap<>();
    for (Candidate candidate : candidates) {
      TraineeCandidateProfileStatus profileStatus = candidate.getStatus();
      String statusName = profileStatus.getStatus();
      if (stringIntegerMap.containsKey(statusName)) {
        int value = stringIntegerMap.get(statusName) + 1;
        stringIntegerMap.put(statusName, value);
      } else {
        stringIntegerMap.put(statusName, 1);
      }
    }
    return stringIntegerMap.entrySet().stream().map(
        stringIntegerEntry -> new DashboardData(stringIntegerEntry.getKey(),
            stringIntegerEntry.getValue())).collect(Collectors.toList());
  }
}
