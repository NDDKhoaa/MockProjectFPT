package fa.mockproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "Delivery_Type")
@Cacheable
public class DeliveryType {
	@Id
	@Column(name="Delivery_Type_ID",unique=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long deliveryTypeId;
	
	@Column(name="Class_ID")
    private long classId;
    
    @Column(name="Remarks",nullable=true)
    private String remarks;
    
    @Column(name="Delivery_Type_Name")
    private String deliveryTypeName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Class_ID") 
    private ClassBatch classBatchClassId;
    
    public DeliveryType() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryType(long classId, String remarks, String deliveryTypeName) {
		super();
		this.classId = classId;
		this.remarks = remarks;
		this.deliveryTypeName = deliveryTypeName;
	}

	public String getDeliveryTypeName() {
		return deliveryTypeName;
	}

	public void setDeliveryTypeName(String deliveryTypeName) {
		this.deliveryTypeName = deliveryTypeName;
	}

	public long getDeliveryTypeId() {
		return deliveryTypeId;
	}

	public void setDeliveryTypeId(long deliveryTypeId) {
		this.deliveryTypeId = deliveryTypeId;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ClassBatch getClassBatchClassId() {
		return classBatchClassId;
	}

	public void setClassBatchClassId(ClassBatch classBatchClassId) {
		this.classBatchClassId = classBatchClassId;
	}

	@Override
	public String toString() {
		return "DeliveryType [deliveryTypeId=" + deliveryTypeId + ", classId=" + classId + ", remarks=" + remarks
				+ ", deliveryTypeName=" + deliveryTypeName + "]";
	}


}
