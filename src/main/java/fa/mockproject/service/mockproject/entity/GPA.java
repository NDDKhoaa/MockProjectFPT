package fa.mockproject.service.mockproject.entity;

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
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private fa.mockproject.service.mockproject.entity.Trainee traineeId;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "attendant_id")
    private Integer attendantId;

    @Column(name = "allowance_id")
    private Integer allowanceId;

    @Column(name = "GPA_result")
    private Integer gpaResult;

    @Column(name = "remarks")
    private Integer remarks;

    @Column(name = "GPAGPA_id")
    private int gpaGpaId;

    public GPA() {
    }

    public GPA(int gpaId, fa.mockproject.service.mockproject.entity.Trainee traineeId, Integer classId, Integer attendantId, Integer allowanceId, Integer gpaResult, Integer remarks, int gpaGpaId) {
        this.gpaId = gpaId;
        this.traineeId = traineeId;
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

    public fa.mockproject.service.mockproject.entity.Trainee getTraineeId() {
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
