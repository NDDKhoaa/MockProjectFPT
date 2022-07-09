package fa.mockproject.model;

import fa.mockproject.entity.Budget;

public class BudgetModel {

    private long budgetId;
    private String item;
    private String unit;
    private Integer unitExpense;
    private Integer quantity;
    private Integer tax;
    private String note;
    
	public BudgetModel() {
		super();
	}
	public BudgetModel(long budgetId, String item, String unit, Integer unitExpense, Integer quantity, Long amount, Integer tax,
			Long sum, String note) {
		super();
		this.budgetId = budgetId;
		this.item = item;
		this.unit = unit;
		this.unitExpense = unitExpense;
		this.quantity = quantity;
		this.tax = tax;
		this.note = note;
	}
	
	public BudgetModel(Budget budget) {
		super();
		this.budgetId = budget.getBudgetId();
		this.item = budget.getItem();
		this.unit = budget.getUnit();
		this.unitExpense = budget.getUnitExpense();
		this.quantity = budget.getQuantity();
		this.tax = budget.getTax();
		this.note = budget.getNote();
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
	public Integer getUnitExpense() {
		return unitExpense;
	}
	public void setUnitExpense(Integer unitExpense) {
		this.unitExpense = unitExpense;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getAmount() {
		if (this.unitExpense == null || this.quantity == null) {
			return null;
		}
		return (long) (this.unitExpense * this.quantity);
	}
	public Integer getTax() {
		return tax;
	}
	public Float getSum() {
		Long amount = this.getAmount();
		if (amount == null || tax == null) {
			return 0F;
		}		
		return (float) amount + amount * tax;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public boolean isEmpty() {
		if ((budgetId == 0)
			&& (item == null || item.trim().equals(""))
			&& (unit == null || unit.trim().equals(""))
			&& (unitExpense == null || unitExpense == 0)
			&& (quantity == null || quantity == 0)
			&& (tax == null || tax == 0)
			&& (note == null || note.trim().equals(""))) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "BudgetModel [budgetId=" + budgetId + ", item=" + item + ", unit=" + unit + ", unitExpense="
				+ unitExpense + ", quantity=" + quantity + ", tax=" + tax + ", note=" + note + "]";
	}
    
}
