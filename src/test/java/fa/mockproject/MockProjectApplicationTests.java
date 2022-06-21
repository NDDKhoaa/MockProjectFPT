package fa.mockproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fa.mockproject.entity.Status;
import fa.mockproject.entity.Trainee;
import fa.mockproject.entity.TraineeCandidateProfile;
import fa.mockproject.repository.TraineeCandidateProfileRepository;
import fa.mockproject.repository.TraineeRepository;

@SpringBootTest
class MockProjectApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	TraineeCandidateProfileRepository traineeCandidateProfileRepository;
	
	@Test
	void test() {
		TraineeCandidateProfile traineeCandidateProfile = new TraineeCandidateProfile();
		traineeCandidateProfile.setFullName("Hieu");
		traineeCandidateProfile.setDateOfBirth(LocalDate.of(2020, 12, 12));
		traineeCandidateProfile.setGender("Male");
		traineeCandidateProfile.setPhone("1234567890");
		
		
		Status status = new Status();
		status.setRemarks("Waiting for class");
		
		List<Status> statuses = new ArrayList<Status>();
		
		statuses.add(status);
		
		Trainee trainee = new Trainee();
		trainee.setTraineeCandidateProfile(traineeCandidateProfile);
		trainee.setStatuses(statuses);
//		traineeCandidateProfile.setTrainee(traineeRepository.findById((long) 13).get());
		
//		traineeRepository.save(trainee);
//		traineeCandidateProfileRepository.save(traineeCandidateProfile);
//		assertEquals(1, traineeRepository.findAll().size());\
		System.out.println(traineeRepository.findAll().size());
		assertEquals(1, traineeRepository.findAll().size());
		
		
	}
	
}
