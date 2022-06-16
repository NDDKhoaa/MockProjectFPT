package fa.mockproject.entity;

import javax.persistence.*;

import fa.mockproject.model.BudgetModel;

@Entity
@Table(name="Budget")
@Cacheable
public class Budget {
    @Id
    @Column(name="budget_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long budgetId;
    
    @Column(name = "item", length = 255, nullable = false)
    private String item;
    
    @Column(name = "unit", length = 255, nullable = false)
    private String unit;
    
    @Column(name = "unit_expense", nullable = false)
    private int unitExpense;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "tax", nullable = false)
    private int tax;
    
    @Column(name = "note", length = 255, nullable = true)
    private String note;
    
    @ManyToOne
    @JoinColumn(name="class_id", nullable = false) 
    private ClassBatch classBatch;

	public Budget() {
		super();
	}

	public Budget(String item, String unit, int unitExpense, int quantity, int tax, String note,
			ClassBatch classBatch) {
		super();
		this.item = item;
		this.unit = unit;
		this.unitExpense = unitExpense;
		this.quantity = quantity;
		this.tax = tax;
		this.note = note;
		this.classBatch = classBatch;
	}
	
	public Budget(BudgetModel budgetModel) {
		super();
		this.item = budgetModel.getItem();
		this.unit = budgetModel.getUnit();
		this.unitExpense = budgetModel.getUnitExpense();
		this.quantity = budgetModel.getQuantity();
		this.tax = budgetModel.getTax();
		this.note = budgetModel.getNote();
	}
	
	public Budget(BudgetModel budgetModel, ClassBatch classBatch) {
		super();
		this.item = budgetModel.getItem();
		this.unit = budgetModel.getUnit();
		this.unitExpense = budgetModel.getUnitExpense();
		this.quantity = budgetModel.getQuantity();
		this.tax = budgetModel.getTax();
		this.note = budgetModel.getNote();
		this.classBatch = classBatch;
	}

	public long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(long budgetId) {
		this.budgetId = budgetId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getUnitExpense() {
		return unitExpense;
	}

	public void setUnitExpense(int unitExpense) {
		this.unitExpense = unitExpense;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ClassBatch getClassBatch() {
		return classBatch;
	}

	public void setClassBatch(ClassBatch classBatch) {
		this.classBatch = classBatch;
	}

	@Override
	public String toString() {
		return "Budget [budgetId=" + budgetId + ", item=" + item + ", unit=" + unit + ", unitExpense=" + unitExpense
				+ ", quantity=" + quantity + ", tax=" + tax + ", note=" + note + ", classBatch=" + classBatch + "]";
	}
    
}
