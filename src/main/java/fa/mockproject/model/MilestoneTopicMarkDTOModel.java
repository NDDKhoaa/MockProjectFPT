package fa.mockproject.model;

import java.util.ArrayList;
import java.util.List;

public class MilestoneTopicMarkDTOModel {
	
	public List<MilestoneTopicMarkModel> milestoneTopicMarkModels = new ArrayList<MilestoneTopicMarkModel>();
	
	
	public MilestoneTopicMarkDTOModel() {
		
	}

	public MilestoneTopicMarkDTOModel(List<MilestoneTopicMarkModel> milestoneTopicMarkModels) {
		super();
		this.milestoneTopicMarkModels = milestoneTopicMarkModels;
	}

	public List<MilestoneTopicMarkModel> getMilestoneTopicMarkModels() {
		return milestoneTopicMarkModels;
	}

	public void setMilestoneTopicMarkModels(List<MilestoneTopicMarkModel> milestoneTopicMarkModels) {
		this.milestoneTopicMarkModels = milestoneTopicMarkModels;
	}
	
	
}
