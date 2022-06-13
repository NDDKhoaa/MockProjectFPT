package fa.mockproject.model;

import fa.mockproject.entity.Budget;

public class BudgetModel {

    private long budgetId;
    private String item;
    private String unit;
    private Integer unitExpense;
    private Integer quantity;
    private Long amount;
    private Integer tax;
    private Long sum;
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
		this.amount = amount;
		this.tax = tax;
		this.sum = sum;
		this.note = note;
	}
	
	public BudgetModel(Budget budget) {
		super();
		this.budgetId = budget.getBudgetId();
		this.item = budget.getItem();
		this.unit = budget.getUnit();
		this.unitExpense = budget.getUnitExpense();
		this.quantity = budget.getQuantity();
		this.amount = budget.getAmount();
		this.tax = budget.getTax();
		this.sum = budget.getSum();
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
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "BudgetModel [budgetId=" + budgetId + ", item=" + item + ", unit=" + unit + ", unitExpense="
				+ unitExpense + ", quantity=" + quantity + ", amount=" + amount + ", tax=" + tax + ", sum=" + sum
				+ ", note=" + note + "]";
	}
    
}
