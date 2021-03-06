package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fa.mockproject.model.ClassAdminModel;

@Entity
@Table(name = "ClassAdmin")
@Cacheable
public class ClassAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "class_admin_id")
	private long classAdminId;
	
	@ManyToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;
	
	@ManyToOne
	@JoinColumn(name = "class_admin_profile_id", nullable = false)
	private ClassAdminProfile classAdminProfile;
	
	@Column(name = "remark", length = 255, nullable = true)
	private String remarks;
	
	public ClassAdmin() {
		super();
	}
	
	public ClassAdmin(long classAdminId) {
		super();
		this.classAdminId = classAdminId;
	}

	public ClassAdmin(long classAdminId, ClassBatch classBatch, ClassAdminProfile classAdminProfile, String remarks) {
		super();
		this.classAdminId = classAdminId;
		this.classBatch = classBatch;
		this.classAdminProfile = classAdminProfile;
		this.remarks = remarks;
	}
	
	public ClassAdmin(ClassAdminModel classAdminModel, ClassBatch classBatch) {
		super();
		this.classAdminId = classAdminModel.getClassAdminId();
		this.classBatch = classBatch;
		this.classAdminProfile = new ClassAdminProfile(classAdminModel);
		this.remarks = classAdminModel.getRemarks();
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
		return "ClassAdmin [classAdminId=" + classAdminId + ", classAdminProfile=" + classAdminProfile + ", remarks="
				+ remarks + "]";
	}
	
}
