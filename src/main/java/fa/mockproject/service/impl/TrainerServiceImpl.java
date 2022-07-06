package fa.mockproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.repository.TrainerProfileRepository;
import fa.mockproject.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
	@Autowired
	private TrainerProfileRepository trainerProfileRepository;
	
	@Override
	public List<TrainerProfile> getAllTrainers(String keyword) {
		if(keyword!=null) {
			return trainerProfileRepository.findAll(keyword); 
		}
		return trainerProfileRepository.findAll();
	}

	@Override
	public void save(TrainerModel trainerModel) {
		TrainerProfile trainerProfile = new TrainerProfile(trainerModel);
		trainerProfileRepository.save(trainerProfile);

	}

	@Override
	public TrainerProfile findByTrainerId(long trainerId) {
		Optional<TrainerProfile> optional = trainerProfileRepository.findById(trainerId);
		TrainerProfile trainer = null;
		if(optional.isPresent()) {
			trainer = optional.get();
		}else {
			throw new RuntimeException("Trainer not found for id"+trainerId);
		}
		return trainer;
	}

	@Override
	public void deleteTrainerProfileById(long id) {
		this.trainerProfileRepository.deleteById(id);
		
	}

}
