package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Channel")
@Cacheable
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "channel_id", length=20,unique = true, nullable = false)
	private String channelId;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id", nullable = true)
	private Candidate candidate;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@Column(name = "channel_name", length = 255, nullable = false)
	private String channelName;

	public Channel() {
		super();
	}

	public Channel(Candidate candidate, String remarks, String channelName) {
		super();
		this.candidate = candidate;
		this.remarks = remarks;
		this.channelName = channelName;
	}
	
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", remarks=" + remarks + ", channelName=" + channelName + "]";
	}

}
