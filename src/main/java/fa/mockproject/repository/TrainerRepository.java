package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.TrainerProfile;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerProfile,Long>{

}
