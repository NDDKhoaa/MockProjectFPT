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
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private Trainee trainee;

    @OneToOne
    @JoinColumn(name = "allowance_group", nullable = false)
    private AllowanceGroup allowanceGroup;

    @Column(name = "allowance_result")
    private int allowanceResult;

    @Column(name = "remarks")
    private Integer remarks;

    public Allowance() {
    }

    public Allowance(long group, Trainee traineeId, AllowanceGroup allowanceGroup, int allowanceResult, Integer remarks) {
        this.allowanceId = group;
        this.trainee = traineeId;
        this.allowanceGroup = allowanceGroup;
        this.allowanceResult = allowanceResult;
        this.remarks = remarks;
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

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }
}
