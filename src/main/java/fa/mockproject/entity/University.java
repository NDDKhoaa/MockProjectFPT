package fa.mockproject.entity;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "University")
@Cacheable
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "university_id", length = 20, unique = true, nullable = false)
	private String universityId;

	@Column(name = "university_name", length = 255, unique = true, nullable = false)
	private String universityName;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@OneToMany(mappedBy = "university")
	private Set<TraineeCandidateProfile> traineeCandidateProfile;

	public University() {
		super();
	}

	public University(String universityName, String remarks, Set<TraineeCandidateProfile> traineeCandidateProfile) {
		super();
		this.universityName = universityName;
		this.remarks = remarks;
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public University(University findById) {
		this.universityId = findById.getUniversityId();
		this.universityName = findById.getUniversityName();
		this.remarks = findById.getRemarks();
	}

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set<TraineeCandidateProfile> getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(Set<TraineeCandidateProfile> traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + ", remarks="
				+ remarks + "]";
	}

}
