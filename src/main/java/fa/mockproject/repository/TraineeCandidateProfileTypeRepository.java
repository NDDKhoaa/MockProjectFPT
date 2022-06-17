package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.TraineeCandidateProfileType;

@Repository
public interface TraineeCandidateProfileTypeRepository extends JpaRepository<TraineeCandidateProfileType, String>{

}
