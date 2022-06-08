package fa.mockproject.entity;


import javax.persistence.*;

@Entity
@Table(name = "GPA")
@Cacheable
public class GPA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "GPA_id", nullable = false, length = 10)
    private int gpaId;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private Trainee traineeId;

    @Column(name = "class_id", length = 10)
    private Integer classId;

    @Column(name = "attendant_id", length = 10)
    private Integer attendantId;

    @Column(name = "allowance_id", length = 10)
    private Integer allowanceId;

    @Column(name = "GPA_result", length = 10)
    private Integer gpaResult;

    @Column(name = "remarks", length = 10)
    private Integer remarks;

    @Column(name = "GPAGPA_id", length = 10)
    private int gpaGpaId;

    public GPA() {
    }

    public GPA(int gpaId, Trainee traineeId, Integer classId, Integer attendantId, Integer allowanceId, Integer gpaResult, Integer remarks, int gpaGpaId) {
        this.gpaId = gpaId;
        this.traineeId = traineeId;
        this.classId = classId;
        this.attendantId = attendantId;
        this.allowanceId = allowanceId;
        this.gpaResult = gpaResult;
        this.remarks = remarks;
        this.gpaGpaId = gpaGpaId;
    }

    public int getGpaId() {
        return gpaId;
    }

    public void setGpaId(int gpaId) {
        this.gpaId = gpaId;
    }

    public Trainee getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
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

    public void setGpaResult(Integer gpaResult) {
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
