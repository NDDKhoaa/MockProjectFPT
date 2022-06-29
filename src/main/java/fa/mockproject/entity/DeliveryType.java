package fa.mockproject.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fa.mockproject.model.DeliveryTypeModel;

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
    
    @OneToMany(mappedBy = "deliveryType", fetch = FetchType.LAZY)
    private List<ClassBatch> classBatchs;

	public DeliveryType() {
		super();
	}

	public DeliveryType(long deliveryTypeId, String deliveryTypeName, String remarks, List<ClassBatch> classBatchs) {
		super();
		this.deliveryTypeId = deliveryTypeId;
		this.deliveryTypeName = deliveryTypeName;
		this.remarks = remarks;
		this.classBatchs = classBatchs;
	}
	
	public DeliveryType(DeliveryTypeModel deliveryTypeModel) {
		super();
		this.deliveryTypeId = deliveryTypeModel.getDeliveryTypeId();
		this.deliveryTypeName = deliveryTypeModel.getDeliveryTypeName();
		this.remarks = deliveryTypeModel.getRemarks();
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

	public List<ClassBatch> getClassBatchs() {
		return classBatchs;
	}

	public void setClassBatchs(List<ClassBatch> classBatchs) {
		this.classBatchs = classBatchs;
	}

    
}
