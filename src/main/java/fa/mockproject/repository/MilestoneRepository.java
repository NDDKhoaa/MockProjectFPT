package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

}
