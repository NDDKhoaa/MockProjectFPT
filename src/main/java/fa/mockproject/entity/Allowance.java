package fa.mockproject.entity;


import javax.persistence.*;

@Entity
@Table(name = "Allowance")
public class Allowance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "allowance_id", nullable = false)
    private long allowanceId;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate_id", nullable = false)
    private Trainee trainee;

    @OneToOne
    @JoinColumn(name = "group_id", nullable = false)
    private AllowanceGroup allowanceGroup;

    @Column(name = "class_id")
    private Integer classId;
    
    @Column(name = "standard_allowance")
    private long standardAllowance;
    
    @Column(name = "level")
    private String level;
    
    @Column(name = "allowance_result")
    private int allowanceResult;

    @Column(name = "remarks")
    private String remarks;
    
    @OneToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;
    
    public Allowance() {
    }

    public Allowance(long allowanceId, Trainee trainee, AllowanceGroup allowanceGroup, Integer classId,
			long standardAllowance, String level, int allowanceResult, String remarks, Milestone milestone) {
		super();
		this.allowanceId = allowanceId;
		this.trainee = trainee;
		this.allowanceGroup = allowanceGroup;
		this.classId = classId;
		this.standardAllowance = standardAllowance;
		this.level = level;
		this.allowanceResult = allowanceResult;
		this.remarks = remarks;
		this.milestone = milestone;
	}



	public long getAllowanceId() {
        return allowanceId;
    }

    public void setAllowanceId(long allowanceId) {
        this.allowanceId = allowanceId;
    }

    public Trainee getTraineeId() {
        return trainee;
    }

    public void setTraineeId(Trainee traineeId) {
        this.trainee = traineeId;
    }

    public AllowanceGroup getAllowanceGroup() {
        return allowanceGroup;
    }

    public void setAllowanceGroup(AllowanceGroup allowanceGroup) {
        this.allowanceGroup = allowanceGroup;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public int getAllowanceResult() {
        return allowanceResult;
    }

    public void setAllowanceResult(int allowanceResult) {
        this.allowanceResult = allowanceResult;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



	public Trainee getTrainee() {
		return trainee;
	}



	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}



	public long getStandardAllowance() {
		return standardAllowance;
	}



	public void setStandardAllowance(long standardAllowance) {
		this.standardAllowance = standardAllowance;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public Milestone getMilestone() {
		return milestone;
	}



	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}
    
    
}
