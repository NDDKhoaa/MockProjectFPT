package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.TraineeCandidateProfileStatus;

@Repository
public interface TraineeCandidateProfileStatusRepository extends JpaRepository<TraineeCandidateProfileStatus, String>{

}
