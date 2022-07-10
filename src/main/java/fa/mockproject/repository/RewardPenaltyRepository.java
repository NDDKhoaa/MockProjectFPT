package fa.mockproject.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.mockproject.entity.RewardPenalty;

public interface RewardPenaltyRepository extends JpaRepository<RewardPenalty, Long> {
	
	@Modifying
	@Transactional
	@Query("Update RewardPenalty r Set r.penaltyPoint = :penaltyPoint, r.date = :date, r.bonusPoint = :bonusPoint, r.reason = :reason Where r.rewardPenaltyId=:rewardPenaltyId")
	void updateById(@Param("rewardPenaltyId") long rewardPenaltyId,@Param("date") LocalDate date, @Param("penaltyPoint") int penaltyPoint,
					@Param("bonusPoint") int bonusPoint, @Param("reason") String reason);
	
	@Modifying
	@Transactional
	@Query("Delete From RewardPenalty rp Where rp.rewardPenaltyId = :rewardPenaltyId")
	void deleteById(@Param("rewardPenaltyId") long rewardPenaltyId);
	
}
