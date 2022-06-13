package fa.mockproject.entity.enumtype;

public enum ClassBatchStatusEnum {
	Draft("Draft"),
	Submitted("Submitted"),
	Rejected("Rejected"),
	Declined("Declined"),
	Planning("Planning"),
	Planned("Planned"),
	InProgress("In-Progress"),
	PendingForReview("Pending For Review"),
	Closed("Closed"),
	WaitingForMoreInformation("WaitingForMoreInformation");
	
	private String string;

	ClassBatchStatusEnum(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
