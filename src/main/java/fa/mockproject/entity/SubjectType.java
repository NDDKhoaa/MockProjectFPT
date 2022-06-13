package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "SubjectType")
@Cacheable
public class SubjectType {
	@Id
	@Column(name="subject_type_id",unique=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subjectTypeId;
	
    @Column(name="remarks",nullable=true)
    private String remarks;
    
    @Column(name="subject_type_name")
    private String subjectTypeName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="class_id") 
    private ClassBatch classBatchClassId;
    
    public SubjectType() {
		// TODO Auto-generated constructor stub
	}

	public SubjectType(String remarks, String subjectTypeName) {
		this.remarks = remarks;
		this.subjectTypeName = subjectTypeName;
	}

	public long getSubjectTypeId() {
		return subjectTypeId;
	}

	public void setSubjectTypeId(long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSubjectTypeName() {
		return subjectTypeName;
	}

	public void setSubjectTypeName(String subjectTypeName) {
		this.subjectTypeName = subjectTypeName;
	}

	public ClassBatch getClassBatchClassId() {
		return classBatchClassId;
	}

	public void setClassBatchClassId(ClassBatch classBatchClassId) {
		this.classBatchClassId = classBatchClassId;
	}

	@Override
	public String toString() {
		return "SubjectType [subjectTypeId=" + subjectTypeId +", remarks=" + remarks
				+ ", subjectTypeName=" + subjectTypeName + "]";
	}
    
    
}
