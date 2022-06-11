package fa.mockproject.service.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
	
	
}
