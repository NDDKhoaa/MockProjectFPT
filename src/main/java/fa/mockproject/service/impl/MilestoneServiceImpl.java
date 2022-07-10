package fa.mockproject.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.AttendantDayCheck;
import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Topic;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.MilestonesModel;
import fa.mockproject.repository.AttendantDayCheckRepository;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.TopicRepository;
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
	
	@Autowired
	TopicRepository topicRepository;
	
	public MilestonesModel getMilestonesModel(long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		
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


	public String createMilestone(long traineeId, Milestone milestone) {
		
		if (milestone.getStartDate() == null || milestone.getEndDate() == null) {
			return "Cannot be empty!";
		} else
		if(milestone.getStartDate().compareTo(LocalDate.now()) < 0 || 
			milestone.getEndDate().compareTo(LocalDate.now()) < 0) {
			return "Cannot input past date!";
		} if (milestone.getSalaryPaid() == null) {
			milestone.setSalaryPaid("No");
		}
		
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		milestone.setTrainee(trainee);
		
		List<LocalDate> dates = milestone.getStartDate().datesUntil(milestone.getEndDate()).collect(Collectors.toList());
		
		String milestoneName = "thg" + milestone.getStartDate().getMonthValue() + "-" + (milestone.getStartDate().getYear() % 100);
		milestone.setMilestoneName(milestoneName);
		milestoneRepository.save(milestone);
		
		int i = 0;
		AttendantDayCheck attendantDayCheck = null;
		List<AttendantDayCheck> attendantDayChecks = new ArrayList<AttendantDayCheck>();
		for(LocalDate date : dates) {
			
			if(!(date.getDayOfWeek().name().equals( DayOfWeek.SATURDAY.name())) && 
					!(date.getDayOfWeek().name().equals( DayOfWeek.SUNDAY.name()))) {
				
				attendantDayCheck = new AttendantDayCheck();
				attendantDayCheck.setDayCheck(date.getDayOfMonth());
				attendantDayCheck.setMilestone(milestone);
				attendantDayCheck.setAttendantStatus("-");
				attendantDayCheck.setMilestone(milestone);
				attendantDayChecks.add(attendantDayCheck);
				attendantDayCheckRepository.save(attendantDayCheck);
			}
		}
		
		return "Update successfully!";
	}


	public String deleteMilestone(long milestoneId) {
		
		milestoneRepository.deleteMilestoneById(milestoneId);
		
		return "Delete Sucess";
	}


	public List<AttendantDayCheck> getAttendanceStatusesByMilestoenId(long milestoneid) {
		
		Optional<Milestone> milestone = milestoneRepository.findById(milestoneid);
		Milestone milestone1 = milestone.get();
		
		List<AttendantDayCheck> attendantDayChecks = milestone1.getAttendantDayChecks();
		Collections.reverse(attendantDayChecks);
		
		return attendantDayChecks;
	}


	public String updateMilestone(List<Milestone> milestones, long traineeId) {
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		List<Topic> topics = new ArrayList<Topic>();
		
		for(Milestone milestone : milestones) {
			Milestone milestoneInRepo = milestoneRepository.findByMilestoneId(milestone.getMilestoneId());
			topics = milestone.getTopics();
			milestone.setTrainee(trainee);
			
			if(topics != null) {
				int i = 0;
				for(Topic topic : topics) {
					topic.setMilestone(milestone);
					topic.setTraineeScore(milestoneInRepo.getTopics().get(i).getTraineeScore());
					System.out.println(topic.getTraineeScore());
					topicRepository.save(topic);
					i++;
				}
			}
			
			List<AttendantDayCheck> attendanceDayChecks =  milestoneRepository.getOne(milestone.getMilestoneId()).getAttendantDayChecks();
			List<LocalDate> dates = milestone.getStartDate().datesUntil(milestone.getEndDate()).collect(Collectors.toList());
	
			int i = 0;
			
			AttendantDayCheck attendantDayCheck = null;
			List<AttendantDayCheck> attendantDayChecks = new ArrayList<AttendantDayCheck>();
			
			for(LocalDate date : dates) {
				
				if(!(date.getDayOfWeek().name().equals( DayOfWeek.SATURDAY.name())) && 
						!(date.getDayOfWeek().name().equals( DayOfWeek.SUNDAY.name()))) {
					
					attendantDayCheck = new AttendantDayCheck();
					attendantDayCheck.setDayCheck(date.getDayOfMonth());
					attendantDayCheck.setMilestone(milestone);
					if(i < attendanceDayChecks.size()) {
						attendantDayCheck.setAttendantStatus(attendanceDayChecks.get(i).getAttendantStatus());
						i++;
					}
					attendantDayChecks.add(attendantDayCheck);
					
					attendantDayCheckRepository.save(attendantDayCheck);
				}
				
			}
			
			milestone.setTopics(topics);
			milestone.setAttendantDayChecks(attendantDayChecks);
			milestoneRepository.save(milestone);
			attendantDayCheckRepository.deleteAll(attendanceDayChecks);
			
		}
		
		return "Update Success";
	}

	public Milestone getMilestone(long milestoneId) {
		return milestoneRepository.findByMilestoneId(milestoneId);
	}

	public Trainee getTraineeByMilestone(long milestoneId) {
		Milestone milestone = milestoneRepository.getOne(milestoneId);
		
		return milestone.getTrainee();
	}
	
}
