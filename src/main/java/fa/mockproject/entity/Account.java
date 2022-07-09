package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fa.mockproject.model.TraineeCandidateProfileModel;

@Entity
@Table(name = "Account")
@Cacheable
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id", unique = true, nullable = false)
	private long accountId;

	@Column(name = "account", unique = true, nullable = true)
	private String account;

	@Column(name = "password", nullable = true)
	private String password;

	@OneToOne(mappedBy = "account")
	@JoinColumn(name = "trainee_candidate_profile_id", nullable = true)
	private TraineeCandidateProfile traineeCandidateProfile;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TraineeCandidateProfile getTraineeCandidateProfile() {
		return traineeCandidateProfile;
	}

	public void setTraineeCandidateProfile(TraineeCandidateProfile traineeCandidateProfile) {
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	@Override
	public String toString() {
		return "Account []";
	}

	public Account(String account, String password, TraineeCandidateProfile traineeCandidateProfile) {
		super();
		this.account = account;
		this.password = password;
		this.traineeCandidateProfile = traineeCandidateProfile;
	}

	public Account(TraineeCandidateProfileModel model) {
		this.account = model.getAccount();
		this.password = model.getPassword();
	}

	public Account() {
		super();
	}

	public Account(Account account) {
		this.account = account.getAccount();
		this.password = account.getPassword();
		this.traineeCandidateProfile = account.getTraineeCandidateProfile();
	}

}