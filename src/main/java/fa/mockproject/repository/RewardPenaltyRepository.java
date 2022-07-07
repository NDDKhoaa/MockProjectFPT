package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.RewardPenalty;

@Repository
public interface RewardPenaltyRepository extends JpaRepository<RewardPenalty, Long> {
	
	
}
