package fa.mockproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.model.TrainerModel;

public interface TrainerService {

	List<TrainerModel> getAllProfile();
	List<Trainer> updateAllTrainerOfOneClass(ClassBatch classBatch);

	void save(TrainerModel trainerModel);
	TrainerProfile findByTrainerId(long trainerId);
	void deleteTrainerProfileById(long id);
	List<TrainerProfile> getAllTrainers(String keyword);
	void getAllTrainers(Model model, Map<String, String> filters);
}
