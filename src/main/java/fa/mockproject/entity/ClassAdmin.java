package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClassAdmin")
@Cacheable
public class ClassAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "class_admin_id")
	private int classAdminId;
	
	@Column(name = "class_id")
	private ClassBatch classBatch;
	
	@Column(name = "class_admin_profile_id")
	private ClassAdminProfile classAdminProfile;
	
	@Column(name = "remark", length = 200)
	private String remarks;
	
	public ClassAdmin() {
		super();
	}

	public ClassAdmin(int classAdminId, ClassBatch classBatch, ClassAdminProfile classAdminProfile, String remarks) {
		super();
		this.classAdminId = classAdminId;
		this.classBatch = classBatch;
		this.classAdminProfile = classAdminProfile;
		this.remarks = remarks;
	}

	public int getClassAdminId() {
		return classAdminId;
	}

	public void setClassAdminId(int classAdminId) {
		this.classAdminId = classAdminId;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public ClassAdminProfile getClassAdminProfile() {
		return classAdminProfile;
	}

	public void setClassAdminProfile(ClassAdminProfile classAdminProfile) {
		this.classAdminProfile = classAdminProfile;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ClassAdmin [classAdminId=" + classAdminId + ", classBatch=" + classBatch + ", classAdminProfile="
				+ classAdminProfile + ", remarks=" + remarks + "]";
	}
	
}
