package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer,Long>{

}
