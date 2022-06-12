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
	
	@SuppressWarnings("unused")
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "class_admin_profile_id")
	private long classAdminProfileId;
	
	@OneToOne(mappedBy = "classAdminProfile")
	private ClassAdmin classAdmin;
	
	@Column(name = "account", length = 255, unique = true, nullable = false)
	private String account;
	
	@Column(name = "full_name", length = 255, nullable = false)
	private String fullName;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(name = "gender", nullable = false)
	private int gender;
	
	@Column(name = "phone", length = 255, unique = true, nullable = false)
	private String phone;
	
	@Column(name = "email", length = 255, unique = true, nullable = false)
	private String email;
	
	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;
	
	public ClassAdminProfile() {
		super();
	}

	public ClassAdminProfile(ClassAdmin classAdmin, String account, String fullName, LocalDate dateOfBirth, int gender,
			String phone, String email, String remarks) {
		super();
		this.classAdmin = classAdmin;
		this.account = account;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}

	public long getClassAdminProfileId() {
		return classAdminProfileId;
	}

	public void setClassAdminProfileId(long classAdminProfileId) {
		this.classAdminProfileId = classAdminProfileId;
	}

	public ClassAdmin getClassAdmin() {
		return classAdmin;
	}

	public void setClassAdmin(ClassAdmin classAdmin) {
		this.classAdmin = classAdmin;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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
