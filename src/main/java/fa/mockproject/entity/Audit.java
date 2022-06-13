package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.entity.enumtype.AuditEventCategoryEnum;

@Entity
@Table(name = "Audit")
@Cacheable
public class Audit {
	
	@SuppressWarnings("unused")
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "audit_id")
	private long auditId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_batch_id", nullable = false)
	private ClassBatch classBatch;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "event_category", length = 255, nullable = false)
	private AuditEventCategoryEnum eventCategory;
	
	@Column(name = "related_party_or_people", length = 255, nullable = false)
	private String relatedPartyOrPeople;
	
	@Column(name = "action", length = 255, nullable = false)
	private String action;
	
	@Column(name = "pic", length = 255, nullable = false)
	private String pic;
	
	@Column(name = "deadline", nullable =  false)
	private LocalDate deadline;
	
	@Column(name = "note", length = 255, nullable = true)
	private String note;
	
	public Audit() {
		super();
	}

	public Audit(ClassBatch classBatch, LocalDate date, AuditEventCategoryEnum eventCategory, String relatedPartyOrPeople,
			String action, String pic, LocalDate deadline, String note) {
		super();
		this.classBatch = classBatch;
		this.date = date;
		this.eventCategory = eventCategory;
		this.relatedPartyOrPeople = relatedPartyOrPeople;
		this.action = action;
		this.pic = pic;
		this.deadline = deadline;
		this.note = note;
	}

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
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
		return "Audit [auditId=" + auditId + ", classBatch=" + classBatch + ", date=" + date + ", eventCategory="
				+ eventCategory + ", relatedPartyOrPeople=" + relatedPartyOrPeople + ", action=" + action + ", pic="
				+ pic + ", deadline=" + deadline + ", note=" + note + "]";
	}
	
}
