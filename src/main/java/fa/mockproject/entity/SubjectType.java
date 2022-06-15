package fa.mockproject.entity;

import javax.persistence.*;

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
    
    @OneToOne(mappedBy = "subjectType")
    private ClassBatch classBatch;

	public SubjectType() {
		super();
	}

	public SubjectType(long subjectTypeId, String subjectTypeName, String remarks, ClassBatch classBatch) {
		super();
		this.subjectTypeId = subjectTypeId;
		this.subjectTypeName = subjectTypeName;
		this.remarks = remarks;
		this.classBatch = classBatch;
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

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	@Override
	public String toString() {
		return "SubjectType [subjectTypeId=" + subjectTypeId + ", subjectTypeName=" + subjectTypeName + ", remarks="
				+ remarks + ", classBatch=" + classBatch + "]";
	}
    
}
