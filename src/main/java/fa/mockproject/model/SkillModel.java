package fa.mockproject.model;

import fa.mockproject.entity.Skill;

public class SkillModel {
	
	private String skillId;
	private String skillName;
	private String remarks;
	
	public SkillModel() {
		super();
	}
	
	public SkillModel(String skillId, String skillName, String remarks) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.remarks = remarks;
	}
	
	public SkillModel(Skill skill) {
		super();
		this.skillId = skill.getSkillId();
		this.skillName = skill.getSkillName();
		this.remarks = skill.getRemarks();
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "SkillModel [skillId=" + skillId + ", skillName=" + skillName + ", remarks=" + remarks + "]";
	}
}
