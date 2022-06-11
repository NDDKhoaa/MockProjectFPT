package fa.mockproject.entity.enumtype;

public enum ClassStatusEnum {
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

	ClassStatusEnum(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
