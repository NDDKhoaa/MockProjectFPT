package fa.mockproject.model;

import fa.mockproject.entity.FormatType;

public class FormatTypeModel {

	private long formatTypeId;
	private String formatTypeName;
	private String remarks;
	
	public FormatTypeModel() {
		super();
	}

	public FormatTypeModel(long formatTypeId, String formatTypeName, String remarks) {
		super();
		this.formatTypeId = formatTypeId;
		this.formatTypeName = formatTypeName;
		this.remarks = remarks;
	}
	
	public FormatTypeModel(FormatType formatType) {
		super();
		this.formatTypeId = formatType.getFormatTypeId();
		this.formatTypeName = formatType.getFormatTypeName();
		this.remarks = formatType.getRemarks();
	}

	public long getFormatTypeId() {
		return formatTypeId;
	}

	public void setFormatTypeId(long formatTypeId) {
		this.formatTypeId = formatTypeId;
	}

	public String getFormatTypeName() {
		return formatTypeName;
	}

	public void setFormatTypeName(String formatTypeName) {
		this.formatTypeName = formatTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "FormatTypeModel [formatTypeId=" + formatTypeId + ", formatTypeName=" + formatTypeName + ", remarks="
				+ remarks + "]";
	}
	
}
