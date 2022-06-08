package fa.mockproject.entity;


import javax.persistence.*;

@Entity
@Table(name = "Status")
@Cacheable
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "status_id", nullable = false, length = 10)
    private Integer statusId;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private Trainee traineeId;

    @Column(name = "remarks", length = 10)
    private Integer remarks;

    @Column(name = "batch_class_id", length = 10)
    private Integer batchClassId;

    public Status() {
    }

    public Status(Integer statusId, Trainee traineeId, Integer remarks, Integer batchClassId) {
        this.statusId = statusId;
        this.traineeId = traineeId;
        this.remarks = remarks;
        this.batchClassId = batchClassId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Trainee getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
    }

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }

    public Integer getBatchClassId() {
        return batchClassId;
    }

    public void setBatchClassId(Integer batchClassId) {
        this.batchClassId = batchClassId;
    }
}
