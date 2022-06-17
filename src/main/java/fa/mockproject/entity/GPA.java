package fa.mockproject.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private Trainee trainee;

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

    public GPA(long gpaId, Trainee trainee, Integer attendantId, Integer allowanceId,
			Integer gpaResult, Integer remarks, int gpaGpaId) {
		super();
		this.gpaId = gpaId;
		this.trainee = trainee;
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

    public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
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
