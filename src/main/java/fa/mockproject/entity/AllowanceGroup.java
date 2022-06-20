
package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "AllowanceGroup")
@Cacheable
public class AllowanceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", nullable = false)
    private long group;

    @OneToOne(mappedBy = "allowanceGroup",cascade = CascadeType.ALL)
    private Allowance allowance;

    @Column(name = "remarks")
    private Integer remarks;

    public AllowanceGroup() {
    }

    public AllowanceGroup(long group, Allowance allowance, Integer remarks) {
        this.group = group;
        this.allowance = allowance;
        this.remarks = remarks;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
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
