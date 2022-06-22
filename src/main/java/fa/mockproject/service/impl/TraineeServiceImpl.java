package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Trainee;
import fa.mockproject.model.TraineeModel;
import fa.mockproject.model.TraineePage;
import fa.mockproject.repository.TraineeCandidateProfileRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.TraineeService;

@Service
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	TraineeCandidateProfileRepository traineeCandidateProfileRepository;
	
	public TraineePage getTraineeModels(Pageable pageable) {
		TraineePage traineePage = new TraineePage();
		List<TraineeModel> traineeModels = new ArrayList<>();
 		Page<Trainee> page = traineeRepository.findAll(pageable);
 		traineePage.setPage(page);
 		
 		List<Trainee> trainees = page.getContent();
 		System.out.println(trainees.get(0));
		for(Trainee trainee : trainees) {
			TraineeModel traineeModel = new TraineeModel();
			traineeModel.setId(trainee.getTraineeCandidateID());
//			traineeModel.setAccount(trainee.getTraineeAccount());
			traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
//			traineeModel.setStatus(trainee.getStatuses().get(0).getRemarks());
			traineeModels.add(traineeModel);
		}
		
		traineePage.setTraineeModels(traineeModels);
		
		return traineePage;
	}


	public TraineeModel getTraineeModel(long id) {
		
		Trainee trainee = traineeRepository.findByTraineeCandidateID(id);
		
		TraineeModel traineeModel = new TraineeModel();
		
		traineeModel.setId(trainee.getTraineeCandidateID());
//		traineeModel.setStatus(trainee.getListStatus().get(0).getRemarks());
//		traineeModel.setAllocationStatus(trainee.get);
		traineeModel.setGender(trainee.getTraineeCandidateProfile().getGender());
		traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
//		traineeModel.setDOB
//		traineeModel.setUniversityName(trainee.get);
//		traineeModel.setFalcutyName(null);
		traineeModel.setPhone(trainee.getTraineeCandidateProfile().getPhone());
		traineeModel.setEmail(trainee.getTraineeCandidateProfile().getEmail());
		
		return traineeModel;
	}


// 	public void update(TraineeModel traineeModelForm) {
// 		Optional<Trainee> trainees = traineeRepository.findById(traineeModelForm.getId());
// 		Trainee trainee = trainees.get();
// 		traineeCandidateProfileRepository.update(trainee.getTraineeCandidateProfile().getTraineeCandidateProfileId(), 
// 				traineeModelForm.getFullName(), traineeModelForm.getPhone(), traineeModelForm.getEmail(), 
// 				traineeModelForm.getGender());
// 		traineeRepository.save(trainee);
}
