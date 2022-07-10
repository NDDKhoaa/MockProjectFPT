package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.ClassBatch;
import fa.mockproject.entity.Trainer;
import fa.mockproject.entity.TrainerProfile;
import fa.mockproject.model.TrainerModel;
import fa.mockproject.repository.TrainerProfileRepository;
import fa.mockproject.repository.TrainerRepository;
import fa.mockproject.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{
	
	@Autowired
	private TrainerProfileRepository trainerProfileRepository;
	@Autowired
	private TrainerRepository trainerRepository;
	
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
	public List<TrainerModel> getAllProfile() {
		List<TrainerModel> trainerModels = trainerProfileRepository.findAll().stream().map(
				trainerProfile -> new TrainerModel(trainerProfile)).collect(Collectors.toCollection(ArrayList::new));
		return trainerModels;
	}

	@Override
	public List<Trainer> updateAllTrainerOfOneClass(ClassBatch classBatch) {
		System.out.println(classBatch.getTrainers());
		List<Trainer> latestTrainers = trainerRepository.saveAll(classBatch.getTrainers());
		List<Trainer> removedTrainers = trainerRepository.findAll();
		try {
			removedTrainers.removeAll(latestTrainers);	
			trainerRepository.deleteAll(removedTrainers);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return latestTrainers;
	}
	
	public void deleteTrainerProfileById(long id) {
		this.trainerProfileRepository.deleteById(id);
	}

}
