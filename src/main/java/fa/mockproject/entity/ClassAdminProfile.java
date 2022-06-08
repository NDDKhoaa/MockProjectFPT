package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ClassAdminProfile")
@Cacheable
public class ClassAdminProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "class_admin_profile_id")
	private int classAdminProfileId;
	
	@OneToOne(mappedBy = "classAdminProfile")
	private ClassAdmin classAdmin;
	
	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(name = "gender", nullable = false)
	private int gender;
	
	@Column(name = "phone", unique = true, nullable = false)
	private long phone;
	
	@Column(name = "email", length = 255, unique = true, nullable = false)
	private String email;
	
	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;
	
	public ClassAdminProfile() {
		super();
	}

	public ClassAdminProfile(int classAdminProfileId, ClassAdmin classAdmin, String fullName, LocalDate dateOfBirth,
			int gender, long phone, String email, String remarks) {
		super();
		this.classAdminProfileId = classAdminProfileId;
		this.classAdmin = classAdmin;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}

	public int getClassAdminProfileId() {
		return classAdminProfileId;
	}

	public void setClassAdminProfileId(int classAdminProfileId) {
		this.classAdminProfileId = classAdminProfileId;
	}

	public ClassAdmin getClassAdmin() {
		return classAdmin;
	}

	public void setClassAdmin(ClassAdmin classAdmin) {
		this.classAdmin = classAdmin;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ClassAdminProfile [classAdminProfileId=" + classAdminProfileId + ", classAdmin=" + classAdmin
				+ ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", remarks=" + remarks + "]";
	}
	
}
