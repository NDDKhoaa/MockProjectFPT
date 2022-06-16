package fa.mockproject.model;

import java.time.LocalDate;

import fa.mockproject.entity.Audit;
import fa.mockproject.entity.enumtype.AuditEventCategoryEnum;

public class AuditModel {

	@SuppressWarnings("unused")
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private long auditId;
	private LocalDate date;
	private AuditEventCategoryEnum eventCategory;
	private String relatedPartyOrPeople;
	private String action;
	private String pic;
	private LocalDate deadline;
	private String note;
	
	public AuditModel() {
		super();
	}
	
	public AuditModel(long auditId, LocalDate date, AuditEventCategoryEnum eventCategory,
			String relatedPartyOrPeople, String action, String pic, LocalDate deadline, String note) {
		super();
		this.auditId = auditId;
		this.date = date;
		this.eventCategory = eventCategory;
		this.relatedPartyOrPeople = relatedPartyOrPeople;
		this.action = action;
		this.pic = pic;
		this.deadline = deadline;
		this.note = note;
	}
	
	public AuditModel(Audit audit) {
		super();
		this.auditId = audit.getAuditId();
		this.date = audit.getDate();
		this.eventCategory = audit.getEventCategory();
		this.relatedPartyOrPeople = audit.getRelatedPartyOrPeople();
		this.action = audit.getAction();
		this.pic = audit.getPic();
		this.deadline = audit.getDeadline();
		this.note = audit.getNote();
	}

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AuditEventCategoryEnum getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(AuditEventCategoryEnum eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getRelatedPartyOrPeople() {
		return relatedPartyOrPeople;
	}

	public void setRelatedPartyOrPeople(String relatedPartyOrPeople) {
		this.relatedPartyOrPeople = relatedPartyOrPeople;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "AuditModel [auditId=" + auditId + ", date=" + date + ", eventCategory=" + eventCategory
				+ ", relatedPartyOrPeople=" + relatedPartyOrPeople + ", action=" + action + ", pic=" + pic
				+ ", deadline=" + deadline + ", note=" + note + "]";
	}
	
}
