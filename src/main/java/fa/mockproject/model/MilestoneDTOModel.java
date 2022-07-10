package fa.mockproject.model;

import java.util.ArrayList;
import java.util.List;

import fa.mockproject.entity.Milestone;

public class MilestoneDTOModel {
	public List<Milestone> milestones = new ArrayList<Milestone>();
	
	public void addMilestone(Milestone milestone) {
		this.milestones.add(milestone);
	}

	public MilestoneDTOModel(List<Milestone> milestones) {
		super();
		this.milestones = milestones;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

}
