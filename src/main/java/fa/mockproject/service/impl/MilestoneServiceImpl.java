package fa.mockproject.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Topic;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.MilestonesModel;
import fa.mockproject.repository.AttendantDayCheckRepository;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.MilestoneService;

@Service
public class MilestoneServiceImpl implements MilestoneService {
	
	@Autowired
	MilestoneRepository milestoneRepository;

	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	AttendantDayCheckRepository attendantDayCheckRepository;
	
	
	public MilestonesModel getMilestonesModel(long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		System.out.println(trainee.getTraineeCandidateID());
		List<Milestone> milestones = trainee.getMilestones();
		
		MilestonesModel milestonesModel = new MilestonesModel();
		
		int totalMaxScore = 0;
		int passingScore = 0;
		int weightNumber = 0;
		
		for(Milestone milestone : milestones) {
			
			String milestoneName = "thg" + milestone.getStartDate().getMonthValue() + "-" + (milestone.getStartDate().getYear() % 100);
			milestone.setMilestoneName(milestoneName);
			
			for(Topic topic : milestone.getTopics()) {
				totalMaxScore += topic.getMaxScore() * topic.getWeightedNumber();
				passingScore += topic.getPassingScore() * topic.getWeightedNumber();
				weightNumber += topic.getWeightedNumber();	
			}
		}
		
		milestonesModel.setTotalMaxScore(totalMaxScore);
		milestonesModel.setTotalPassingScore(passingScore);
		milestonesModel.setTotalWeightedNumber(weightNumber);
		milestonesModel.setMileStones(milestones);
		
		return milestonesModel;
	}


	public String createMilestone(long traineeId, Milestone mileStone) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		mileStone.setTrainee(trainee);
		
		List<LocalDate> dates = mileStone.getStartDate().datesUntil(mileStone.getEndDate()).collect(Collectors.toList());
		
		int i = 0;
		AttendantDayCheck attendantDayCheck = null;
		for(LocalDate date : dates) {
			
			if(!(date.getDayOfWeek().name().equals( DayOfWeek.SATURDAY.name())) && 
					!(date.getDayOfWeek().name().equals( DayOfWeek.SUNDAY.name()))) {
				
				System.out.println(date.getDayOfMonth());
				attendantDayCheck = new AttendantDayCheck();
				attendantDayCheck.setDayCheck(date.getDayOfMonth());
				attendantDayCheck.setMilestone(mileStone);
				
				attendantDayCheckRepository.save(attendantDayCheck);
			}
		}
		
		milestoneRepository.save(mileStone);
		return "Update successfully!";
	}


	public String deleteMilestone(long milestoneId) {
		
		milestoneRepository.deleteById(milestoneId);
		
		return "Delete Sucess";
	}
	
}
