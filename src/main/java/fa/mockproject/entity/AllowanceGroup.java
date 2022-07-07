
package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "AllowanceGroup")
@Cacheable
public class AllowanceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", nullable = false)
    private long groupId;

    @OneToOne(mappedBy = "allowanceGroup",cascade = CascadeType.ALL)
    private Allowance allowance;

    @Column(name = "remarks")
    private Integer remarks;

    public AllowanceGroup() {
    }

    public AllowanceGroup(long groupId, Allowance allowance, Integer remarks) {
		super();
		this.groupId = groupId;
		this.allowance = allowance;
		this.remarks = remarks;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public Allowance getAllowance() {
		return allowance;
	}

	public void setAllowance(Allowance allowance) {
		this.allowance = allowance;
	}

	public Integer getRemarks() {
		return remarks;
	}

	public void setRemarks(Integer remarks) {
		this.remarks = remarks;
	}

}