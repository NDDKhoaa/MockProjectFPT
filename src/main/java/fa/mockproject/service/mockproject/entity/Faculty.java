package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.TraineeCandidateProfile;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty")
@Cacheable
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "faculty_id")
	private long facultyId;
	
	@Column(name = "faculty_name", length = 255, unique = true, nullable = false)
	private String facultyName;
	
	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;
	
	@OneToOne(mappedBy = "faculty")
	private TraineeCandidateProfile traineeCandidateProfile;
	
	public Faculty() {
		super();
	}

	public Faculty(String facultyName, String remarks, TraineeCandidateProfile traineeCandidateProfile) {
		super();
		this.facultyName = facultyName;
		this.remarks = remarks;
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(long facultyId) {
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

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", remarks=" + remarks + "]";
	}
	
}
