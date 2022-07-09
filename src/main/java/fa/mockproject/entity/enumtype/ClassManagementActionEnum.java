package fa.mockproject.entity.enumtype;

public enum ClassManagementActionEnum {
	Get(null, null),
	GetList(null, null),
	Create("Created", ClassBatchStatusEnum.Draft),
	Update("Updated", null),
	Submit("Submited", ClassBatchStatusEnum.Submitted),
	Reject("Rejected", ClassBatchStatusEnum.Rejected),
	Cancel("Cancelled", ClassBatchStatusEnum.Cancelled),
	Approve("Approved", ClassBatchStatusEnum.Planning),
	Decline("Declined", ClassBatchStatusEnum.Declined),
	Accept("Accepted", ClassBatchStatusEnum.Planned),
	Start("Started", ClassBatchStatusEnum.InProgress),
	Finish("Finished", ClassBatchStatusEnum.PendingForReview),
	Close("Closed", ClassBatchStatusEnum.Closed),
	Request("Requested", ClassBatchStatusEnum.WaitingForMoreInformation);
	
	private String past;
	private ClassBatchStatusEnum statusAfterAction;

	ClassManagementActionEnum(String past, ClassBatchStatusEnum statusAfterAction) {
		this.past = past;
		this.statusAfterAction = statusAfterAction;
	}

	public String getPast() {
		return past;
	}

	public ClassBatchStatusEnum getStatusAfterAction() {
		return statusAfterAction;
	}

}
