package src.main.java.fa.mockproject.entity;



@Entity
@Table(name = "FormatType")
@Cacheable
public class FormatType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int formattype_id;

	@OneToOne
	@JoinColumn(name = "class_id", nullable = false)
	private ClassBatch classBatch;
	
	@Column(name= "remarks")
	private int remarks;
	


	public int getFormattype_id() {
		return formattype_id;
	}

	public void setFormattype_id(int formattype_id) {
		this.formattype_id = formattype_id;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	public int getRemarks() {
		return remarks;
	}

	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}



	@Override
	public String toString() {
		return "FormatType [formattype_id=" + formattype_id + ", classBatch=" + classBatch + ", remarks=" + remarks
				+ "]";
	}

	public FormatType(int formattype_id, ClassBatch classBatch, int remarks) {
		super();
		this.formattype_id = formattype_id;
		this.classBatch = classBatch;
		this.remarks = remarks;
	}
	
	
}