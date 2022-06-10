package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.RewardPenalty;

public interface RewardPenaltyRepository extends JpaRepository<RewardPenalty, Long> {
	
}
