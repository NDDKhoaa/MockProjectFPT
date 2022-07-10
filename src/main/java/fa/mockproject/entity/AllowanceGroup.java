package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "AllowanceGroup")
public class AllowanceGroup {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", nullable = false)
    private long groupId;

    @OneToOne(mappedBy = "allowanceGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Allowance allowance;
    
    @Column(name = "allowanceGroupName")
    private String allowanceGroupName;
    
    @OneToOne
    @JoinColumn(name = "trainee_candidate_id", nullable = false)
    private Trainee trainee;
    
    @Column(name = "remarks")
    private Integer remarks;

    public AllowanceGroup() {
    }

    public AllowanceGroup(long group, Allowance allowance, Integer remarks) {
        this.groupId = group;
        this.allowance = allowance;
        this.remarks = remarks;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long group) {
        this.groupId = group;
    }

    public Allowance getAllowance() {
        return allowance;
    }

    public void setAllowance(Allowance allowance) {
        this.allowance = allowance;
    }

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }

	public String getAllowanceGroupName() {
		return allowanceGroupName;
	}

	public void setAllowanceGroupName(String allowanceGroupName) {
		this.allowanceGroupName = allowanceGroupName;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
    
    
}
