package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "DeliveryType")
@Cacheable
public class DeliveryType {
	@Id
	@Column(name="delivery_type_id",unique=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deliveryTypeId;
    
    @Column(name="delivery_type_name")
    private String deliveryTypeName;
    
    @Column(name="remarks",nullable=true)
    private String remarks;
    
    @OneToOne(mappedBy = "deliveryType")
    private ClassBatch classBatch;

	public DeliveryType() {
		super();
	}

	public DeliveryType(long deliveryTypeId, String deliveryTypeName, String remarks, ClassBatch classBatch) {
		super();
		this.deliveryTypeId = deliveryTypeId;
		this.deliveryTypeName = deliveryTypeName;
		this.remarks = remarks;
		this.classBatch = classBatch;
	}

	public long getDeliveryTypeId() {
		return deliveryTypeId;
	}

	public void setDeliveryTypeId(long deliveryTypeId) {
		this.deliveryTypeId = deliveryTypeId;
	}

	public String getDeliveryTypeName() {
		return deliveryTypeName;
	}

	public void setDeliveryTypeName(String deliveryTypeName) {
		this.deliveryTypeName = deliveryTypeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	@Override
	public String toString() {
		return "DeliveryType [deliveryTypeId=" + deliveryTypeId + ", deliveryTypeName=" + deliveryTypeName
				+ ", remarks=" + remarks + ", classBatch=" + classBatch + "]";
	}
    
}
