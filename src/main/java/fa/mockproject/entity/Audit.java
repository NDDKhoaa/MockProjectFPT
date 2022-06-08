package fa.mockproject.entity;

import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Audit")
@Cacheable
public class Audit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "audit_id")
	private int auditId;
	
	@OneToOne(mappedBy = "audit")
	private ClassBatch classBatch;
	
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "event_category", length = 255, nullable = false)
	private String eventCategory;
	
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

	public Audit(int auditId, ClassBatch classBatch, LocalDate date, String eventCategory, String relatedPartyOrPeople,
			String action, String pic, LocalDate deadline, String note) {
		super();
		this.auditId = auditId;
		this.classBatch = classBatch;
		this.date = date;
		this.eventCategory = eventCategory;
		this.relatedPartyOrPeople = relatedPartyOrPeople;
		this.action = action;
		this.pic = pic;
		this.deadline = deadline;
		this.note = note;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
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

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
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
