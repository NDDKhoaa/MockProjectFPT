package fa.mockproject.service.mockproject.service;

import fa.mockproject.entity.Trainer;

public interface TrainerService {
	void save(Trainer trainee);

	Trainer findByTrainer_id(int trainer_id);
}
