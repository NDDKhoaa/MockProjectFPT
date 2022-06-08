package src.main.java.fa.mockproject.entity;

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
	private int facultyId;
	
	@Column(name = "faculty_name", length = 100, unique = true, nullable = false)
	private String facultyName;
	
	@Column(name = "remarks", length = 200, nullable = true)
	private String remarks;
	
	@OneToOne(mappedBy = "faculty")
	private TraineeCandidateProfile traineeCandidateProfile;
	
	public Faculty() {
		super();
	}

	public Faculty(int facultyId, String facultyName, String remarks, TraineeCandidateProfile traineeCandidateProfile) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.remarks = remarks;
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
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
