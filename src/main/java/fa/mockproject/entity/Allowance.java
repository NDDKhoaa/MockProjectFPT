package fa.mockproject.entity;


import javax.persistence.*;

@Entity
@Table(name = "Allowance")
@Cacheable
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

    @Column(name = "allowance_result", nullable = false)
    private int allowanceResult;

    @Column(name = "remarks",length = 255,nullable = true)
    private String remarks;
    
    @OneToOne(mappedBy = "allowance")
    private GPA gpa;

    public Allowance() {
    }
    
    public Allowance(long group, Trainee traineeId, AllowanceGroup allowanceGroup, int allowanceResult, String remarks) {
        this.allowanceId = group;
        this.trainee = traineeId;
        this.allowanceGroup = allowanceGroup;
        this.allowanceResult = allowanceResult;
        this.remarks = remarks;
    }
    
    

    public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public GPA getGpa() {
		return gpa;
	}

	public void setGpa(GPA gpa) {
		this.gpa = gpa;
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
}
