package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.TrainerProfile;

public interface TrainerProfileRepository extends JpaRepository<TrainerProfile, Long> {

}
