package fa.mockproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.TraineeCandidateProfile;

public interface TraineeCandidateProfileRepository extends JpaRepository<TraineeCandidateProfile, Long> {

	@Transactional
	@Modifying
	@Query("update TraineeCandidateProfile set "
			+ "fullName =:fullName, "
			+ "phone = :phone, "
			+ "email = :email, "
			+ "gender = :gender "
			+ "where traineeCandidateProfileId =:traineeCandidateProfileId")
	void update(@Param("traineeCandidateProfileId") int traineeCandidateProfileId, @Param("fullName") String fullName, 
			 @Param("phone") String phone, @Param("email") String email,@Param("gender") String gender);

}
