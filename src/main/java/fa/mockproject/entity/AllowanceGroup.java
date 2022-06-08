package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "AllowanceGroup")
@Cacheable
public class AllowanceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group", nullable = false, length = 10)
    private int group;

    @OneToOne(mappedBy = "allowance_group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Allowance allowance;

    @Column(name = "remarks", length = 10)
    private Integer remarks;

    public AllowanceGroup() {
    }

    public AllowanceGroup(int group, Allowance allowance, Integer remarks) {
        this.group = group;
        this.allowance = allowance;
        this.remarks = remarks;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
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
