package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Account;
import fa.mockproject.entity.AllowanceGroup;
import fa.mockproject.entity.Faculty;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.entity.University;
import fa.mockproject.model.TraineeModel;
import fa.mockproject.model.TraineePage;
import fa.mockproject.repository.AccountRepository;
import fa.mockproject.repository.AllowanceGroupRepository;
import fa.mockproject.repository.FacultyRepository;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.TraineeCandidateProfileRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.repository.UniversityRepository;
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
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UniversityRepository universityRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	public TraineePage getTraineeModels(Pageable pageable) {
		TraineePage traineePage = new TraineePage();
		List<TraineeModel> traineeModels = new ArrayList<>();
 		Page<Trainee> page = traineeRepository.findAll(pageable);
 		traineePage.setPage(page);
 		
 		List<Trainee> trainees = page.getContent();
 		
		for(Trainee trainee : trainees) {
			TraineeModel traineeModel = new TraineeModel();
			traineeModel.setId(trainee.getTraineeCandidateId());
			if(trainee.getTraineeCandidateProfile() != null) {
				traineeModel.setAccount(trainee.getTraineeCandidateProfile().getAccount().getAccount());
				traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
			}	
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
		if(trainee.getTraineeCandidateProfile() != null) {
			traineeModel.setGender(trainee.getTraineeCandidateProfile().getGender());
			traineeModel.setFullName(trainee.getTraineeCandidateProfile().getFullName());
			traineeModel.setDayOfBirth(trainee.getTraineeCandidateProfile().getDateOfBirth());
			traineeModel.setAccount(trainee.getTraineeCandidateProfile().getAccount().getAccount());
			traineeModel.setUniversityName(trainee.getTraineeCandidateProfile().getUniversity().getUniversityName());
			traineeModel.setFalcutyName(trainee.getTraineeCandidateProfile().getFaculty().getFacultyName());
			traineeModel.setPhone(trainee.getTraineeCandidateProfile().getPhone());
			traineeModel.setEmail(trainee.getTraineeCandidateProfile().getEmail());
			
		}
		if(!(trainee.getMilestones().isEmpty())) {
			traineeModel.setSalaryPaid(trainee.getMilestones().get(0).getSalaryPaid());
		}
		if(trainee.getCommitment() != null) {
			traineeModel.setCommitment(String.valueOf(trainee.getCommitment().getCommittedWorkingDuration()));
			traineeModel.setEndDate(trainee.getCommitment().getCommittedWorkingEndDate());
		}
		
		traineeModel.setTpbAccount(trainee.getTpbankAccount());
		
		if(trainee.getAllocation() != null) {
			traineeModel.setAllocationStatus(trainee.getAllocation().getAllocationStatus());
		}
		
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
 		
 		TraineeCandidateProfile traineeCandidateProfile = null;
 		
 		if(trainee.getTraineeCandidateProfile() != null) {
 			traineeCandidateProfile = trainee.getTraineeCandidateProfile();
 		} else {
 			traineeCandidateProfile = new TraineeCandidateProfile();
 		}
 		
 		String fullName = traineeModel.getFullName();
 		
 		Account account = new Account();
 		if(traineeModel.getAccount() == null) {
 			String accountName = fullName.substring(fullName.lastIndexOf(" ") + 1) + fullName.charAt(0) 
				+ fullName.charAt(fullName.indexOf(" ") + 1);
 			
 			account.setAccount(accountName);
 		}
 		
 		traineeCandidateProfile.setFullName(traineeModel.getFullName());
 		traineeCandidateProfile.setGender(traineeModel.getGender());
 		traineeCandidateProfile.setEmail(traineeModel.getEmail());
 		traineeCandidateProfile.setPhone(traineeModel.getPhone());
 		traineeCandidateProfile.setDateOfBirth(traineeModel.getDayOfBirth());
 		
 		
 		
 		Faculty faculty = facultyRepository.findByName(traineeModel.getFalcutyName());
 		
 		traineeCandidateProfile.setFaculty(faculty);
 		
 		University university = universityRepository.findByName(traineeModel.getUniversityName());
 		
 		traineeCandidateProfile.setUniversity(university);

 		
 		
 		Milestone milestone = null;
 		if(!(trainee.getMilestones().isEmpty())) {
 			milestone = trainee.getMilestones().get(0);
 			milestone.setSalaryPaid(traineeModel.getSalaryPaid());
 			milestoneRepository.save(milestone);
 		} else {
 			milestone = new Milestone();
 			milestone.setSalaryPaid(traineeModel.getSalaryPaid());
 			milestone.setTrainee(trainee);
 			milestoneRepository.save(milestone);
 		}
 		
 		trainee.setTpbankAccount(traineeModel.getTpbAccount());
 		AllowanceGroup allowanceGroup = null;

 		if(trainee.getAllowanceGroup() != null) {
 			allowanceGroup = trainee.getAllowanceGroup();
 			allowanceGroup.setAllowanceGroupName(traineeModel.getAllowanceGroup());
 			trainee.setAllowanceGroup(allowanceGroup);
 		} else {
 			AllowanceGroup newAllowanceGroup = new AllowanceGroup();
 			newAllowanceGroup.setAllowanceGroupName(traineeModel.getAllowanceGroup());
 			newAllowanceGroup.setTrainee(trainee);
 			allowanceGroupRepository.save(newAllowanceGroup);
 		}
 		
 		trainee.setTraineeCandidateProfile(traineeCandidateProfile);
 		account.setTraineeCandidateProfile(traineeCandidateProfile);
 		
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


	@Override
	public List<TraineeModel> getTraineeModelsByClassId(long classId) {
		// TODO Auto-generated method stub
		return null;
	}



// 	public void update(TraineeModel traineeModelForm) {
// 		
}
