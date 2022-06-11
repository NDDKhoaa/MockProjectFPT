package fa.mockproject.service.mockproject.entity;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.entity.Channel;
import fa.mockproject.entity.EntryTest;
import fa.mockproject.entity.Interview;
import fa.mockproject.entity.Location;
import fa.mockproject.entity.Offer;
import fa.mockproject.entity.TraineeCandidateProfile;
import org.springframework.format.annotation.DateTimeFormat;

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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "channel_id", nullable = false, insertable = false, updatable = false)
	private Set<Channel> channel;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", nullable = false, insertable = false, updatable = false)
	private Set<Location> location;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "entry_test_id", nullable = false, insertable = false, updatable = false)
	private Set<EntryTest> entryTest;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "interview_id", nullable = false, insertable = false, updatable = false)
	private Set<Interview> interview;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id", nullable = false, insertable = false, updatable = false)
	private Set<Offer> offer;

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

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Set<Channel> getChannel() {
		return channel;
	}

	public void setChannel(Set<Channel> channel) {
		this.channel = channel;
	}

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
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

}