package fa.mockproject.entity;

import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Candidate")
@Cacheable
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "candidate_id", unique = true, nullable = false)
	private long candidateId;

	@Column(name = "trainee_candidate_profile_id", nullable = false)
	private TraineeCandidateProfile traineeCandidateProfile;

	@DateTimeFormat
	@Column(name = "application_date", nullable = false)
	private Date applicationDate;

	@Column(name = "channel_id", nullable = false)
	private Channel channel;

	@Column(name = "location_id", nullable = false)
	private Location location;

	@Column(name = "entry_test_id", nullable = false)
	private EntryTest entryTest;

	@Column(name = "interview_id", nullable = false)
	private Interview interviewId;

	@Column(name = "offer_id", nullable = false)
	private Offer offerId;

	@Column(name = "status", length = 250, nullable = false)
	private String status;

	@Column(name = "remarks", length = 250, nullable = false)
	private String remarks;

	public Candidate() {
		super();
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public EntryTest getEntryTest() {
		return entryTest;
	}

	public void setEntryTest(EntryTest entryTest) {
		this.entryTest = entryTest;
	}

	public Interview getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Interview interviewId) {
		this.interviewId = interviewId;
	}

	public Offer getOfferId() {
		return offerId;
	}

	public void setOfferId(Offer offerId) {
		this.offerId = offerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", applicationDate=" + applicationDate + ", channel=" + channel
				+ ", location=" + location + ", entryTest=" + entryTest + ", interviewId=" + interviewId + ", offerId="
				+ offerId + ", status=" + status + ", remarks=" + remarks + "]";
	}

}