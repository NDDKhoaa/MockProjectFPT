package src.main.java.fa.mockproject.entity;

import main.java.fa.mockproject.entity.ClassBatch;


@Entity
@Table(name = "Supplier/Partner")
@Cacheable
public class SupplierPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name= "supplierpartner_id")
	private int supplierpartner_id;
	
	@OneToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;
	
	@Column(name= "remarks")
	private int remarks;
	
	
	
	@Column(name= "supplierpartner_name")
	private int supplierpartner_name;

	public int getSupplierpartner_id() {
		return supplierpartner_id;
	}

	public void setSupplierpartner_id(int supplierpartner_id) {
		this.supplierpartner_id = supplierpartner_id;
	}


	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public int getSupplierpartner_name() {
		return supplierpartner_name;
	}

	public void setSupplierpartner_name(int supplierpartner_name) {
		this.supplierpartner_name = supplierpartner_name;
	}

	@Override
	public String toString() {
		return "SupplierPartner [supplierpartner_id=" + supplierpartner_id +  ", remarks="
				+ remarks + ", classBatch=" + classBatch + ", supplierpartner_name=" + supplierpartner_name + "]";
	}

	public SupplierPartner(int supplierpartner_id, int remarks, ClassBatch classBatch,
			int supplierpartner_name) {
		super();
		this.supplierpartner_id = supplierpartner_id;
		this.remarks = remarks;
		this.classBatch = classBatch;
		this.supplierpartner_name = supplierpartner_name;
	}
	
	
}
