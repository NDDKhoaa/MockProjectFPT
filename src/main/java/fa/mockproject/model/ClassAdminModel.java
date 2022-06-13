package fa.mockproject.model;

import java.time.LocalDate;

import fa.mockproject.entity.ClassAdmin;
import fa.mockproject.entity.ClassAdminProfile;

public class ClassAdminModel {
	
	private long classAdminId;
	private String fullName;
	private LocalDate dateOfBirth;
	private Integer gender;
	private String phone;
	private String email;
	private String account;
	private String remarks;
	
	public ClassAdminModel() {
		super();
	}

	public ClassAdminModel(long classAdminId, String fullName, LocalDate dateOfBirth, Integer gender, String phone,
			String email, String account, String remarks) {
		super();
		this.classAdminId = classAdminId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.account = account;
		this.remarks = remarks;
	}
	
	public ClassAdminModel(ClassAdmin classAdmin) {
		super();
		this.classAdminId = classAdmin.getClassAdminId();
		this.fullName = classAdmin.getClassAdminProfile().getFullName();
		this.dateOfBirth = classAdmin.getClassAdminProfile().getDateOfBirth();
		this.gender = classAdmin.getClassAdminProfile().getGender();
		this.phone = classAdmin.getClassAdminProfile().getPhone();
		this.email = classAdmin.getClassAdminProfile().getEmail();
		this.account = classAdmin.getClassAdminProfile().getAccount();
		this.remarks = classAdmin.getRemarks();
	}

	public long getClassAdminId() {
		return classAdminId;
	}

	public void setClassAdminId(long classAdminId) {
		this.classAdminId = classAdminId;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ClassAdminModel [classAdminId=" + classAdminId + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", account=" + account
				+ ", remarks=" + remarks + "]";
	}
	
}
