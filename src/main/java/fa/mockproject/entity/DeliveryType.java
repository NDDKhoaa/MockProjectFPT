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
	
	@Column(name="class_id")
    private long classId;
    
    @Column(name="remarks",nullable=true)
    private String remarks;
    
    @Column(name="delivery_type_name")
    private String deliveryTypeName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="class_id") 
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
