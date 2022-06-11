package fa.mockproject.model;

public class BudgetModel {

    private long budgetId;
    private String item;
    private String unit;
    private int unitExpense;
    private int quantity;
    private Long amount;
    private int tax;
    private Long sum;
    private String note;
    
	public BudgetModel() {
		super();
	}
	public BudgetModel(long budgetId, String item, String unit, int unitExpense, int quantity, Long amount, int tax,
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
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
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
