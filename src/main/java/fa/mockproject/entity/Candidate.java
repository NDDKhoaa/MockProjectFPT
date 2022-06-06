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
	
	@Column(name = "status",length=250, nullable = false)
	private String status;
	
	@Column(name = "remarks",length=250, nullable = false)
	private String remarks;
}