package fa.mockproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.TrainerProfile;

@Repository
public interface TrainerProfileRepository extends JpaRepository<TrainerProfile,Long>{
	
	@Query("SELECT t FROM TrainerProfile t WHERE "
			+ " CONCAT(t.trainerProfileId,t.account,t.fullName,t.gender,t.dateOfBirth,t.unit,t.major,t.phone,t.email,t.experience,t.remarks)"
			+ " LIKE %?1%")
	public Page<TrainerProfile> findAll(String keyword, Pageable pageable);
}
