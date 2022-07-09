package fa.mockproject.service;

import java.util.List;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.model.TrainerModel;

public interface TrainerService {

	List<TrainerModel> getAllProfile();
	List<Trainer> updateAllTrainerOfOneClass(ClassBatch classBatch);
//	List<TrainerProfile> getAllTrainers();
	void save(TrainerModel trainerModel);
	TrainerProfile findByTrainerId(long trainerId);
	void deleteTrainerProfileById(long id);
	List<TrainerProfile> getAllTrainers(String keyword);
}
