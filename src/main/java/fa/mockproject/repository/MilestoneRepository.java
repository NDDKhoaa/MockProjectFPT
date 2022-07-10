package fa.mockproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Milestone;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

	Milestone findByMilestoneId(long milestoneId);
	
	@Modifying
	@Transactional
	@Query("Delete From Milestone m Where m.milestoneId = :milestoneId")
	void deleteMilestoneById(@Param("milestoneId") long milestoneId);

}
