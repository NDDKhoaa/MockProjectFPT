package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.Candidate;

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
@Table(name = "Offer")
@Cacheable
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "offer_id", unique = true, nullable = false)
	private long offerId;

	@Column(name = "job_rank", nullable = false)
	private int jobRank;

	@Column(name = "technology", length = 250, nullable = false)
	private String technology;

	@Column(name = "offer_salary", nullable = false)
	private long offerSalary;

	@Column(name = "contract_type", length = 250, nullable = false)
	private String contractType;

	@Column(name = "remarks", length = 200, nullable = true)
	private String remarks;

	@ManyToOne
	@JoinColumn(name = "candidate_id", nullable = false)
	private Candidate candidate;

	public Offer() {
		super();
	}

	public Offer(int jobRank, String technology, long offerSalary, String contractType, String remarks) {
		super();
		this.jobRank = jobRank;
		this.technology = technology;
		this.offerSalary = offerSalary;
		this.contractType = contractType;
		this.remarks = remarks;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public int getJobRank() {
		return jobRank;
	}

	public void setJobRank(int jobRank) {
		this.jobRank = jobRank;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public long getOfferSalary() {
		return offerSalary;
	}

	public void setOfferSalary(long offerSalary) {
		this.offerSalary = offerSalary;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", jobRank=" + jobRank + ", technology=" + technology + ", offerSalary="
				+ offerSalary + ", contractType=" + contractType + ", remarks=" + remarks + "]";
	}

}