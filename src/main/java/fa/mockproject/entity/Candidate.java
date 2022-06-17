package fa.mockproject.entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fa.mockproject.model.TraineeCandidateProfileModel;

@Entity
@Table(name = "Candidate")
@Cacheable
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "candidate_id", unique = true, nullable = false)
	private long candidateId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TraineeCandidateProfile traineeCandidateProfile;

	@DateTimeFormat
	@Column(name = "application_date", nullable = false)
	private LocalDate applicationDate;

	@ManyToOne
	@JoinColumn(name = "channel_id", nullable = true)
	private Channel channel;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "entry_test_id", nullable = true)
	private Set<EntryTest> entryTest;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "interview_id", nullable = true)
	private Set<Interview> interview;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id", nullable = true)
	private Set<Offer> offer;
	
	@ManyToOne
	@JoinColumn(name = "status", nullable = true)
	private TraineeCandidateProfileStatus status;

	@Column(name = "remarks", length = 255, nullable = true)
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

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Set<EntryTest> getEntryTest() {
		return entryTest;
	}

	public void setEntryTest(Set<EntryTest> entryTest) {
		this.entryTest = entryTest;
	}

	public Set<Interview> getInterview() {
		return interview;
	}

	public void setInterview(Set<Interview> interview) {
		this.interview = interview;
	}

	public Set<Offer> getOffer() {
		return offer;
	}

	public void setOffer(Set<Offer> offer) {
		this.offer = offer;
	}

	public TraineeCandidateProfileStatus getStatus() {
		return status;
	}

	public void setStatus(TraineeCandidateProfileStatus status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Candidate(TraineeCandidateProfileModel model, Channel channel2, TraineeCandidateProfile profile2,TraineeCandidateProfileStatus status2) {
		Date dateApplicationDate = model.getApplicationDate();
		LocalDate localDateApplicationDate = dateApplicationDate.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		this.applicationDate = localDateApplicationDate;
		this.channel = channel2;
		this.status = status2;
		this.remarks = model.getRemarks();
		this.traineeCandidateProfile= profile2;
	}

}