package fa.mockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.mockproject.entity.Milestone;
import fa.mockproject.entity.Topic;
import fa.mockproject.entity.Trainee;
import fa.mockproject.model.MilestoneTopicMarkModel;
import fa.mockproject.model.TopicModel;
import fa.mockproject.repository.MilestoneRepository;
import fa.mockproject.repository.TopicRepository;
import fa.mockproject.repository.TraineeRepository;
import fa.mockproject.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	MilestoneRepository milestoneRepository;
	
	public String createTopic(TopicModel topicModel, Topic topic, String milestoneId) {
		long milestoneId1 = Long.parseLong(milestoneId);
		Milestone milestone = milestoneRepository.getOne(milestoneId1);
		
		String traineeid = String.valueOf(milestone.getTrainee().getTraineeCandidateId()); 
		topic.setMaxScore(topicModel.getMaxScore());
		topic.setPassingScore(topicModel.getPassingScore());
		topic.setWeightedNumber(topicModel.getWeightedNumber());
		topic.setMilestone(milestone);
		topicRepository.save(topic);
		
		return traineeid;
	}

	public List<Topic> getTopics(String traineeId) {
		long traineeId1 = Long.parseLong(traineeId);
		
		Trainee trainee = traineeRepository.getOne(traineeId1);
		
		trainee.getMilestones();
		
		return null;
	}

	public List<MilestoneTopicMarkModel> getTopicMark(long traineeId) {
		
		Trainee trainee = traineeRepository.findByTraineeCandidateId(traineeId);
		MilestoneTopicMarkModel milestoneTopicMarkModel = null;
		List<MilestoneTopicMarkModel> milestoneTopicMarkModels = new ArrayList<MilestoneTopicMarkModel>();
		List<Milestone> milestones = trainee.getMilestones();
		
		for(Milestone milestone : milestones) {
			milestoneTopicMarkModel = new MilestoneTopicMarkModel();
			milestoneTopicMarkModel.setMilestoneName(milestone.getMilestoneName());
			milestoneTopicMarkModel.setTopics(milestone.getTopics());
			
			double totalScore = 0;
			double scoreWeighted = 0;
			double maxScoreWeighted = 0;
			double average = 0;
			
			for(Topic topic : milestone.getTopics()) {
				scoreWeighted += topic.getTraineeScore()*topic.getWeightedNumber();
				maxScoreWeighted += topic.getMaxScore()*topic.getWeightedNumber();
			}
			
			average = scoreWeighted/maxScoreWeighted;
			totalScore = average*100;

			milestoneTopicMarkModel.setTotal((int) totalScore);
			milestoneTopicMarkModels.add(milestoneTopicMarkModel);
		}
		
		return milestoneTopicMarkModels;
	}

	public String updateTopics(List<MilestoneTopicMarkModel> milestoneTopicMarkModels) {
		
		for(MilestoneTopicMarkModel milestoneTopicMarkModel : milestoneTopicMarkModels) {
			List<Topic> topics = milestoneTopicMarkModel.getTopics();
			for(Topic topic : topics) {
				topicRepository.updateTraineeScoreByTopicId(topic.getTopicId(), topic.getTraineeScore());
			}
		}
		
		return "Update successfully!!";
	}

	public String deleteTopic(long topicId) {

		topicRepository.deleteById(topicId);
		
		return "Delete successfully";
	}

}
