package fa.mockproject.model;

import java.time.LocalDate;

public class ClassAdminModel {
	
	private long classAdminId;
	private String fullName;
	private LocalDate dateOfBirth;
	private int gender;
	private String phone;
	private String email;
	private String remarks;
	
	public ClassAdminModel() {
		super();
	}

	public ClassAdminModel(long classAdminId, String fullName, LocalDate dateOfBirth, int gender, String phone,
			String email, String remarks) {
		super();
		this.classAdminId = classAdminId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
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
		return "ClassAdminModel [classAdminId=" + classAdminId + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", remarks=" + remarks
				+ "]";
	}
	
}
