package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.Trainer;
import fa.mockproject.model.TrainerModel;

public interface TrainerService {
	
	List<TrainerModel> getAllProfile();
	Trainer findByTrainerId(long trainerId);
	List<Trainer> updateAllTrainerOfOneClass(ClassBatch classBatch);
}
