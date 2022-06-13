package fa.mockproject.model;

import fa.mockproject.entity.SubjectType;

public class SubjectTypeModel {

	private long subjectTypeId;
    private String subjectTypeName;
    private String remarks;
    
	public SubjectTypeModel() {
		super();
	}
	
	public SubjectTypeModel(long subjectTypeId, String subjectTypeName, String remarks) {
		super();
		this.subjectTypeId = subjectTypeId;
		this.subjectTypeName = subjectTypeName;
		this.remarks = remarks;
	}
	
	public SubjectTypeModel(SubjectType subjectType) {
		super();
		this.subjectTypeId = subjectType.getSubjectTypeId();
		this.subjectTypeName = subjectType.getSubjectTypeName();
		this.remarks = subjectType.getRemarks();
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

	@Override
	public String toString() {
		return "SubjectTypeModel [subjectTypeId=" + subjectTypeId + ", subjectTypeName=" + subjectTypeName
				+ ", remarks=" + remarks + "]";
	}
    
}
