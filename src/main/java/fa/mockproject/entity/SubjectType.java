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
import javax.persistence.Table;

import fa.mockproject.model.SubjectTypeModel;

@Entity
@Table(name = "SubjectType")
@Cacheable
public class SubjectType {
	@Id
	@Column(name="subject_type_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subjectTypeId;
	
	@Column(name="subject_type_name", length = 255, nullable = true)
	private String subjectTypeName;
	
    @Column(name="remarks", length = 255, nullable = true)
    private String remarks;
    
    @OneToMany(mappedBy = "subjectType", fetch = FetchType.LAZY)
    private List<ClassBatch> classBatchs;

	public SubjectType() {
		super();
	}

	public SubjectType(long subjectTypeId, String subjectTypeName, String remarks, List<ClassBatch> classBatchs) {
		super();
		this.subjectTypeId = subjectTypeId;
		this.subjectTypeName = subjectTypeName;
		this.remarks = remarks;
		this.classBatchs = classBatchs;
	}

	public SubjectType(SubjectTypeModel subjectTypeModel) {
		super();
		this.subjectTypeId = subjectTypeModel.getSubjectTypeId();
		this.subjectTypeName = subjectTypeModel.getSubjectTypeName();
		this.remarks = subjectTypeModel.getRemarks();
	}

	public long getSubjectTypeId() {
		return subjectTypeId;
	}

	public void setSubjectTypeId(long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	public String getSubjectTypeName() {
		return subjectTypeName;
	}

	public void setSubjectTypeName(String subjectTypeName) {
		this.subjectTypeName = subjectTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<ClassBatch> getClassBatchs() {
		return classBatchs;
	}

	public void setClassBatchs(List<ClassBatch> classBatchs) {
		this.classBatchs = classBatchs;
	}

	@Override
	public String toString() {
		return "SubjectType [subjectTypeId=" + subjectTypeId + ", subjectTypeName=" + subjectTypeName + ", remarks="
				+ remarks + "]";
	}
    
}
