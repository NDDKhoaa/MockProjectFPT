package fa.mockproject.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.ClassAdminModel;

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
	
	@OneToMany(mappedBy = "classAdminProfile", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<ClassAdmin> classAdmins;
	
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

	public ClassAdminProfile(long classAdminProfileId, List<ClassAdmin> classAdmins, String account, String fullName,
			LocalDate dateOfBirth, int gender, String phone, String email, String remarks) {
		super();
		this.classAdminProfileId = classAdminProfileId;
		this.classAdmins = classAdmins;
		this.account = account;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}
	
	public ClassAdminProfile(ClassAdminModel classAdminModel) {
		super();
		this.classAdminProfileId = classAdminModel.getClassAdminProfileId();
		this.account = classAdminModel.getAccount();
		this.fullName = classAdminModel.getFullName();
		this.dateOfBirth = classAdminModel.getDateOfBirth();
		this.gender = Optional.ofNullable(classAdminModel.getGender()).orElse(0);
		this.phone = classAdminModel.getPhone();
		this.email = classAdminModel.getEmail();
		this.remarks = classAdminModel.getRemarks();
	}

	public long getClassAdminProfileId() {
		return classAdminProfileId;
	}

	public void setClassAdminProfileId(long classAdminProfileId) {
		this.classAdminProfileId = classAdminProfileId;
	}

	public List<ClassAdmin> getClassAdmins() {
		return classAdmins;
	}

	public void setClassAdmins(List<ClassAdmin> classAdmins) {
		this.classAdmins = classAdmins;
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
		return "ClassAdminProfile [classAdminProfileId=" + classAdminProfileId + ", account=" + account + ", fullName="
				+ fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", phone=" + phone + ", email="
				+ email + ", remarks=" + remarks + "]";
	}
	
}
