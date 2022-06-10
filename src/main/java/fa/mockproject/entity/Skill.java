package fa.mockproject.entity;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Skill")
@Cacheable
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "skill_id", length = 20, unique = true, nullable = false)
	private String skillId;

	@Column(name = "skill_name", length = 255, nullable = false)
	private String skillName;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@OneToOne
	@JoinColumn(name = "trainee_candidate_profile_id", nullable = true)
	private TraineeCandidateProfile traineeCanditaCandidateProfile;

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

	public TraineeCandidateProfile getTraineeCanditaCandidateProfile() {
		return traineeCanditaCandidateProfile;
	}

	public void setTraineeCanditaCandidateProfile(TraineeCandidateProfile traineeCanditaCandidateProfile) {
		this.traineeCanditaCandidateProfile = traineeCanditaCandidateProfile;
	}

	public Skill() {
		super();
	}

	public Skill(String skillId, String skillName, String remarks,
			TraineeCandidateProfile traineeCanditaCandidateProfile) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.remarks = remarks;
		this.traineeCanditaCandidateProfile = traineeCanditaCandidateProfile;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", remarks=" + remarks
				+ ", traineeCanditaCandidateProfile=" + traineeCanditaCandidateProfile + "]";
	}

	

	

}