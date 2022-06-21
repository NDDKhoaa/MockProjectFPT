package fa.mockproject.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fa.mockproject.entity.Status;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.repository.TraineeCandidateProfileRepository;
import fa.mockproject.repository.TraineeRepository;

class TraineeTest {

	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	TraineeCandidateProfileRepository traineeCandidateProfileRepository;
	
	@Test
	void test() {
		TraineeCandidateProfile traineeCandidateProfile = new TraineeCandidateProfile();
		traineeCandidateProfile.setFullName("Hieu");
		
		Status status = new Status();
		status.setRemarks("Waiting for class");
		
		List<Status> statuses = new ArrayList<Status>();
		
		statuses.add(status);
		
		Trainee trainee = new Trainee();
		trainee.setTraineeCandidateProfile(traineeCandidateProfile);
		trainee.setStatuses(statuses);
		
		traineeRepository.save(trainee);
		
		assertEquals(1, traineeRepository.findAll().size());
	}
	
}