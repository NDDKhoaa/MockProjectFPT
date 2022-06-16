package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.Trainer;
import fa.mockproject.model.TrainerModel;

public interface TrainerService {
	List<Trainer> getAllTrainers();
	void save(TrainerModel trainerModel);

	Trainer findByTrainer_id(int trainer_id);
}
