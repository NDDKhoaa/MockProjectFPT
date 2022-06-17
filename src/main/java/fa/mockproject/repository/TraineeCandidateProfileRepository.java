package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.TraineeCandidateProfile;

@Repository
public interface TraineeCandidateProfileRepository extends JpaRepository<TraineeCandidateProfile, Long>{

}
