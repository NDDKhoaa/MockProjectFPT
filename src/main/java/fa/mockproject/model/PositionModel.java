package fa.mockproject.model;

import fa.mockproject.entity.Position;

public class PositionModel {
	private String positionId;
	private String positionName;
	private String remarks;
	
	public PositionModel() {
		super();
	}
	
	public PositionModel(String positionId, String positionName, String remarks) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.remarks = remarks;
	}
	
	public PositionModel(Position position) {
		super();
		this.positionId = position.getPositionId();
		this.positionName = position.getPositionName();
		this.remarks = position.getRemarks();
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "PositionModel [positionId=" + positionId + ", positionName=" + positionName + ", remarks="
				+ remarks + "]";
	}
}
