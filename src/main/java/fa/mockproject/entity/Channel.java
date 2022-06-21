package fa.mockproject.entity;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Channel")
@Cacheable
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "channel_id", length = 20, unique = true, nullable = false)
	private String channelId;

	@Column(name = "remarks", length = 255, nullable = true)
	private String remarks;

	@Column(name = "channel_name", length = 255, nullable = false)
	private String channelName;

	@OneToMany(mappedBy = "channel")
	private Set<Candidate> candidate;

	public Channel() {
		super();
	}

	public Channel(Channel get) {
		super();
		this.channelId = get.getChannelId();
		this.remarks = get.getRemarks();
		this.channelName = get.getChannelName();
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public Set<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(Set<Candidate> candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return channelName;
	}

}
