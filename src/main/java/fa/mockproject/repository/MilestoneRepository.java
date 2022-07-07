package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Milestone;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

}
