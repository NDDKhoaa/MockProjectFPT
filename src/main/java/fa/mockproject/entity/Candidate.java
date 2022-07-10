package fa.mockproject.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id", unique = true, nullable = false)
	private long candidateId;

	@OneToOne(mappedBy = "candidate", cascade = CascadeType.MERGE)
	@JoinColumn(name = "trainee_candidate_profile_id", unique = true, nullable = false)
	private TraineeCandidateProfile traineeCandidateProfile;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "application_date", nullable = false)
	private LocalDateTime applicationDate;

	@ManyToOne
	@JoinColumn(name = "channel_id", nullable = false)
	private Channel channel;

	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "entry_test_id", nullable = true)
	private List<EntryTest> entryTests;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "interview_id", nullable = true)
	private List<Interview> interviews;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id", nullable = true)
	private List<Offer> offers;

	@ManyToOne
	@JoinColumn(name = "status", nullable = false)
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

	public LocalDateTime getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDateTime applicationDate) {
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

	public List<EntryTest> getEntryTests() {
		return entryTests;
	}

	public void setEntryTests(List<EntryTest> entryTests) {
		this.entryTests = entryTests;
	}

	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
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

	public Candidate(TraineeCandidateProfileModel model, Channel channel2, Location location2,
		 TraineeCandidateProfileStatus status2) {
		LocalDate localDateApplicationDate = model.getApplicationDate();
		this.applicationDate = localDateApplicationDate.atStartOfDay();
		this.channel = channel2;
		this.location = location2;
		this.status = status2;
		this.remarks = model.getRemarks();
	}

	public Candidate(Candidate candidate) {
		this.candidateId = candidate.getCandidateId();
		this.traineeCandidateProfile = candidate.getTraineeCandidateProfile();
		this.applicationDate = candidate.getApplicationDate();
		this.channel = candidate.getChannel();
		this.location = candidate.getLocation();
		this.entryTests = candidate.getEntryTests();
		this.interviews = candidate.getInterviews();
		this.offers = candidate.getOffers();
		this.status = candidate.getStatus();
		this.remarks = candidate.getRemarks();
	}

	public Candidate(Candidate candidate2, Channel channel2, Location location2,TraineeCandidateProfileStatus status2) {
		this.applicationDate = candidate2.getApplicationDate();
		this.channel = channel2;
		this.location = location2;
		this.status = status2;
		this.remarks = candidate2.getRemarks();
		this.traineeCandidateProfile = candidate2.getTraineeCandidateProfile();
	}

	public Candidate(Candidate candidateID2, TraineeCandidateProfileStatus status2) {
		this.candidateId = candidateID2.getCandidateId();
		this.traineeCandidateProfile = candidateID2.getTraineeCandidateProfile();
		this.applicationDate = candidateID2.getApplicationDate();
		this.channel = candidateID2.getChannel();
		this.location = candidateID2.getLocation();
		this.entryTests = candidateID2.getEntryTests();
		this.interviews = candidateID2.getInterviews();
		this.offers = candidateID2.getOffers();
		this.status = status2;
		this.remarks = candidateID2.getRemarks();
	}

}