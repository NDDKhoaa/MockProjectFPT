package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.AllowanceGroup;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.University;
import fa.mockproject.model.TraineeModel;
import fa.mockproject.model.TraineePage;
import fa.mockproject.repository.AllowanceGroupRepository;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.TraineeCandidateProfileRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.TraineeService;

@Service
public class TraineeServiceImpl implements TraineeService {
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	TraineeCandidateProfileRepository traineeCandidateProfileRepository;
	
	@Autowired
	MilestoneRepository milestoneRepository;
	
	@Autowired
	AllowanceGroupRepository allowanceGroupRepository;
	
	public TraineePage getTraineeModels(Pageable pageable) {
		TraineePage traineePage = new TraineePage();
		List<TraineeModel> traineeModels = new ArrayList<>();
 		Page<Trainee> page = traineeRepository.findAll(pageable);
 		traineePage.setPage(page);
 		
 		List<Trainee> trainees = page.getContent();
 		
		for(Trainee trainee : trainees) {
			TraineeModel traineeModel = new TraineeModel();
			traineeModel.setId(trainee.getTraineeCandidateId());
			traineeModel.setAccount(trainee.getTraineeCandidateProfile().getAccount().getAccount());
			traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
//			traineeModel.setStatus(trainee.getStatuses().get(0).getRemarks());
			traineeModels.add(traineeModel);
		}
		
		traineePage.setTraineeModels(traineeModels);
		
		return traineePage;
	}


	public TraineeModel getTraineeModel(long id) {
		
		Trainee trainee = traineeRepository.findByTraineeCandidateId(id);
		
		TraineeModel traineeModel = new TraineeModel();

		
		traineeModel.setId(trainee.getTraineeCandidateId());
		traineeModel.setGender(trainee.getTraineeCandidateProfile().getGender());
		traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
		traineeModel.setDayOfBirth(trainee.getTraineeCandidateProfile().getDateOfBirth());
		traineeModel.setAccount(trainee.getTraineeCandidateProfile().getAccount().getAccount());
		traineeModel.setUniversityName(trainee.getTraineeCandidateProfile().getUniversity().getUniversityName());
		traineeModel.setFalcutyName(trainee.getTraineeCandidateProfile().getFaculty().getFacultyName());
		traineeModel.setPhone(trainee.getTraineeCandidateProfile().getPhone());
		traineeModel.setEmail(trainee.getTraineeCandidateProfile().getEmail());
		traineeModel.setSalaryPaid(trainee.getMilestones().get(0).getSalaryPaid());
		traineeModel.setTpbAccount(trainee.getTpbankAccount());
		traineeModel.setCommitment(String.valueOf(trainee.getCommitment().getCommittedWorkingDuration()));
		traineeModel.setEndDate(trainee.getCommitment().getCommittedWorkingEndDate());
		traineeModel.setAllocationStatus(trainee.getAllocation().getAllocationStatus());
		if(trainee.getAllowanceGroup() != null) {
			traineeModel.setAllowanceGroup(trainee.getAllowanceGroup().getAllowanceGroupName());
		}
		
		
		return traineeModel;
	}
	
	public void save(Trainee trainee) {
		traineeRepository.save(trainee);
	}


	public String updateTrainee(TraineeModel traineeModel) {
		
 		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeModel.getId());
 		
 		TraineeCandidateProfile traineeCandidateProfile = trainee.getTraineeCandidateProfile();
 		
 		traineeCandidateProfile.setFullName(traineeModel.getFullName());
 		traineeCandidateProfile.setGender(traineeModel.getGender());
 		traineeCandidateProfile.setEmail(traineeModel.getEmail());
 		traineeCandidateProfile.setPhone(traineeModel.getPhone());
 		traineeCandidateProfile.setDateOfBirth(traineeModel.getDayOfBirth());
 		
 		Faculty faculty = traineeCandidateProfile.getFaculty();
 		faculty.setFacultyName(traineeModel.getFalcutyName());
 		University university = traineeCandidateProfile.getUniversity();
 		university.setUniversityName(traineeModel.getUniversityName());
 		traineeCandidateProfile.setUniversity(university);
 		traineeCandidateProfile.setFaculty(faculty);
 		
 		Milestone milestone = trainee.getMilestones().get(0);
 		milestone.setSalaryPaid(traineeModel.getSalaryPaid());
 		milestoneRepository.save(milestone);
 		trainee.setTpbankAccount(traineeModel.getTpbAccount());
 		AllowanceGroup allowanceGroup = trainee.getAllowanceGroup();
 		System.out.println(allowanceGroup);
 		if(allowanceGroup != null) {
 			allowanceGroup.setAllowanceGroupName(traineeModel.getAllowanceGroup());
 			trainee.setAllowanceGroup(allowanceGroup);
 		} else {
 			AllowanceGroup newAllowanceGroup = new AllowanceGroup();
 			newAllowanceGroup.setAllowanceGroupName(traineeModel.getAllowanceGroup());
 			newAllowanceGroup.setTrainee(trainee);
 			allowanceGroupRepository.save(newAllowanceGroup);
 		}
 		trainee.setTraineeCandidateProfile(traineeCandidateProfile);
 		
 		traineeRepository.save(trainee);
 		
		return "Update successfully!";
	}


	public String deleteTrainee(long[] numbers) {
		for(long number : numbers) {
			traineeRepository.deleteTraineeById(number);
		}
		return "Delete Successfully!";
	}


	public String deleteTraineeById(long traineeId) {
		traineeRepository.deleteTraineeById(traineeId);
		return "Delete Successfully!";
	}



// 	public void update(TraineeModel traineeModelForm) {
// 		
}
