package fa.mockproject.model;

public class FormatTypeModel {

	private long formattype_id;
	private String formatTypeName;
	private String remarks;
	
	public FormatTypeModel() {
		super();
	}
	
	public FormatTypeModel(long formattype_id, String formatTypeName, String remarks) {
		super();
		this.formattype_id = formattype_id;
		this.formatTypeName = formatTypeName;
		this.remarks = remarks;
	}

	public long getFormattype_id() {
		return formattype_id;
	}

	public void setFormattype_id(long formattype_id) {
		this.formattype_id = formattype_id;
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
		return "FormatTypeModel [formattype_id=" + formattype_id + ", formatTypeName=" + formatTypeName + ", remarks="
				+ remarks + "]";
	}
	
}
