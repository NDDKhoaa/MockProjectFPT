package fa.mockproject.model;

public class SubSubjectTypeModel {
	
	private long subSubjectTypeId;
    private String subSubjectTypeName;
    private String remarks;
    
	public SubSubjectTypeModel() {
		super();
	}
	
	public SubSubjectTypeModel(long subSubjectTypeId, String subSubjectTypeName, String remarks) {
		super();
		this.subSubjectTypeId = subSubjectTypeId;
		this.subSubjectTypeName = subSubjectTypeName;
		this.remarks = remarks;
	}

	public long getSubSubjectTypeId() {
		return subSubjectTypeId;
	}

	public void setSubSubjectTypeId(long subSubjectTypeId) {
		this.subSubjectTypeId = subSubjectTypeId;
	}

	public String getSubSubjectTypeName() {
		return subSubjectTypeName;
	}

	public void setSubSubjectTypeName(String subSubjectTypeName) {
		this.subSubjectTypeName = subSubjectTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "SubSubjectTypeModel [subSubjectTypeId=" + subSubjectTypeId + ", subSubjectTypeName="
				+ subSubjectTypeName + ", remarks=" + remarks + "]";
	}

}
