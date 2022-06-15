package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "Status")
@Cacheable
public class Status {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "status_id", nullable = false)
    private long statusId;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate_id", nullable = false)
    private Trainee trainee;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "batch_class_id")
    private Integer batchClassId;

    public Status() {
    }

    public Status(long statusId, Trainee trainee, String remarks, Integer batchClassId) {
        this.statusId = statusId;
        this.trainee = trainee;
        this.remarks = remarks;
        this.batchClassId = batchClassId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public Trainee getTraineeId() {
        return trainee;
    }

    public void setTraineeId(Trainee traineeId) {
        this.trainee = traineeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBatchClassId() {
        return batchClassId;
    }

    public void setBatchClassId(Integer batchClassId) {
        this.batchClassId = batchClassId;
    }

}
