package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ClassAdmin")
@Cacheable
public class ClassAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "class_admin_id")
	private long classAdminId;
	
	@OneToOne(mappedBy = "classAdmin")
	private ClassBatch classBatch;
	
	@OneToOne(mappedBy = "class_admin", fetch = FetchType.LAZY)
	private ClassAdminProfile classAdminProfile;
	
	@Column(name = "remark", length = 255, nullable = true)
	private String remarks;
	
	public ClassAdmin() {
		super();
	}

	public ClassAdmin(ClassBatch classBatch, ClassAdminProfile classAdminProfile, String remarks) {
		super();
		this.classBatch = classBatch;
		this.classAdminProfile = classAdminProfile;
		this.remarks = remarks;
	}

	public long getClassAdminId() {
		return classAdminId;
	}

	public void setClassAdminId(long classAdminId) {
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
