package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "GPA")
@Cacheable
public class GPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "GPA_id", nullable = false)
    private long gpaId;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate_id", nullable = false)
    private Trainee trainee;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "attendant_id")
    private Integer attendantId;

    @Column(name = "allowance_id")
    private Integer allowanceId;

    @Column(name = "GPA_result", columnDefinition = "int default 0")
    private int gpaResult;

    @Column(name = "remarks")
    private Integer remarks;

    @Column(name = "GPAGPA_id")
    private int gpaGpaId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    public GPA() {
    }

    public GPA(int gpaId, Trainee traineeId, Integer classId, Integer attendantId, Integer allowanceId, Integer gpaResult, Integer remarks, int gpaGpaId) {
        this.gpaId = gpaId;
        this.trainee = traineeId;
        this.classId = classId;
        this.attendantId = attendantId;
        this.allowanceId = allowanceId;
        this.gpaResult = gpaResult;
        this.remarks = remarks;
        this.gpaGpaId = gpaGpaId;
    }

    public long getGpaId() {
        return gpaId;
    }

    public void setGpaId(long gpaId) {
        this.gpaId = gpaId;
    }

    public Trainee getTraineeId() {
        return trainee;
    }

    public void setTraineeId(Trainee traineeId) {
        this.trainee = traineeId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(Integer attendantId) {
        this.attendantId = attendantId;
    }

    public Integer getAllowanceId() {
        return allowanceId;
    }

    public void setAllowanceId(Integer allowanceId) {
        this.allowanceId = allowanceId;
    }

    public Integer getGpaResult() {
        return gpaResult;
    }

    public void setGpaResult(int gpaResult) {
        this.gpaResult = gpaResult;
    }

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }

    public int getGpaGpaId() {
        return gpaGpaId;
    }

    public void setGpaGpaId(int gpaGpaId) {
        this.gpaGpaId = gpaGpaId;
    }
}
