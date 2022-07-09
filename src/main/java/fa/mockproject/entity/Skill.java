package fa.mockproject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.SkillModel;

@Entity
@Table(name = "Skill")
@Cacheable
public class Skill {

	@Id
	@Column(name = "skill_id", length = 20, unique = true, nullable = false)
	private String skillId;

	@Column(name = "skill_name", length = 255, nullable = false)
	private String skillName;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@OneToMany(mappedBy = "skill")
	private Set<TraineeCandidateProfile> traineeCandidateProfiles;
	
	@OneToMany(mappedBy = "skill")
	private List<ClassBatch> classBatchs;

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

	public Set<TraineeCandidateProfile> getTraineeCandidateProfiles() {
		return traineeCandidateProfiles;
	}

	public void setTraineeCandidateProfiles(Set<TraineeCandidateProfile> traineeCandidateProfiles) {
		this.traineeCandidateProfiles = traineeCandidateProfiles;
	}

	public List<ClassBatch> getClassBatchs() {
		return classBatchs;
	}

	public void setClassBatchs(List<ClassBatch> classBatchs) {
		this.classBatchs = classBatchs;
	}

	public Skill() {
		super();
	}

	public Skill(String skillId, String skillName, String remarks,
			Set<TraineeCandidateProfile> traineeCandidateProfiles) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.remarks = remarks;
		this.traineeCandidateProfiles = traineeCandidateProfiles;
	}

	public Skill(String skillId, String skillName, String remarks,
			Set<TraineeCandidateProfile> traineeCandidateProfiles, List<ClassBatch> classBatchs) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.remarks = remarks;
		this.traineeCandidateProfiles = traineeCandidateProfiles;
		this.classBatchs = classBatchs;
	}

	public Skill(Skill skill) {
		super();
		this.skillId = skill.getSkillId();
		this.skillName = skill.getSkillName();
		this.remarks = skill.getRemarks();
	}
	
	public Skill(SkillModel skillModel) {
		super();
		this.skillId = skillModel.getSkillId();
		this.skillName = skillModel.getSkillName();
		this.remarks = skillModel.getRemarks();
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", remarks=" + remarks + "]";
	}

}