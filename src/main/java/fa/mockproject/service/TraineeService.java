package fa.mockproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Trainee;
import fa.mockproject.model.TraineeModel;
import fa.mockproject.repository.TraineeRepository;

@Service
public class TraineeService {
	
	@Autowired
	TraineeRepository traineeRepository;
	
	
	public List<TraineeModel> getTraineeModelList() {
		List<TraineeModel> traineeModels = new ArrayList<>();
 		ArrayList<Trainee> trainees = (ArrayList<Trainee>) traineeRepository.findAll();
		for(Trainee trainee : trainees) {
			TraineeModel traineeModel = new TraineeModel();
			traineeModel.setId(trainee.getTraineeCandidateID());
//			traineeModel.setAccount(trainee.getTraineeAccount());
			traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
			traineeModel.setStatus(trainee.getListStatus().get(0).getRemarks());
			traineeModels.add(traineeModel);
		}
		return traineeModels;
	}


	public TraineeModel getTraineeModel(long id) {
		Trainee trainee = traineeRepository.findById(id).get();
		TraineeModel traineeModel = new TraineeModel();
		traineeModel.setId(trainee.getTraineeCandidateID());
		traineeModel.setStatus(trainee.getListStatus().get(0).getRemarks());
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
}
