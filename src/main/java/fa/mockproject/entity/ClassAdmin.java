package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
	private List<ClassBatch> classBatchs;
	
	@OneToOne(mappedBy = "class_admin", fetch = FetchType.LAZY)
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

	public ClassAdmin(long classAdminId, List<ClassBatch> classBatchs, ClassAdminProfile classAdminProfile,
			String remarks) {
		super();
		this.classAdminId = classAdminId;
		this.classBatchs = classBatchs;
		this.classAdminProfile = classAdminProfile;
		this.remarks = remarks;
	}

	public long getClassAdminId() {
		return classAdminId;
	}

	public void setClassAdminId(long classAdminId) {
		this.classAdminId = classAdminId;
	}

	public List<ClassBatch> getClassBatchs() {
		return classBatchs;
	}

	public void setClassBatchs(List<ClassBatch> classBatchs) {
		this.classBatchs = classBatchs;
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
	
}
