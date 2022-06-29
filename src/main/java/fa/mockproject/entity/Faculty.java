package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty")
@Cacheable
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "faculty_id", length = 20, unique = true, nullable = false)
	private String facultyId;

	@Column(name = "faculty_name", length = 255, unique = true, nullable = false)
	private String facultyName;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@OneToMany(mappedBy = "faculty")
	private List<TraineeCandidateProfile> traineeCandidateProfile;

	public Faculty() {
		super();
	}

	public Faculty(String facultyId, String facultyName, String remarks,
			List<TraineeCandidateProfile> traineeCandidateProfile) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.remarks = remarks;
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public Faculty(Faculty findById) {
		this.facultyId = findById.facultyId;
		this.facultyName = findById.facultyName;
		this.remarks = findById.remarks;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<TraineeCandidateProfile> getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(List<TraineeCandidateProfile> traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	@Override
	public String toString() {
		return facultyName;
	}

}
