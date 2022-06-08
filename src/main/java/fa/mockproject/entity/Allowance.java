package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "Allowance")
@Cacheable
public class Allowance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group", nullable = false)
    private long group;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private Trainee traineeId;

    @OneToOne
    @JoinColumn(name = "allowance_group", nullable = false)
    private AllowanceGroup allowanceGroup;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "allowance_result" )
    private int allowanceResult;

    @Column(name = "remarks")
    private Integer remarks;

    public Allowance() {
    }

    public Allowance(long group, Trainee traineeId, AllowanceGroup allowanceGroup, Integer classId, int allowanceResult, Integer remarks) {
        this.group = group;
        this.traineeId = traineeId;
        this.allowanceGroup = allowanceGroup;
        this.classId = classId;
        this.allowanceResult = allowanceResult;
        this.remarks = remarks;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    public Trainee getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
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

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }
}
