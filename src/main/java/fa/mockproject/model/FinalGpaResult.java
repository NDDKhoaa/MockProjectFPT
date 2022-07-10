package fa.mockproject.model;

public class FinalGpaResult {
	private int finalAcademicMark;
	private int finalDisciplinaryPoint;
	private int finalBonus;
	private int finalPelnaty;
	private int finalGpaResult;
	public FinalGpaResult() {
		super();
	}
	public FinalGpaResult(int finalAcademicMark, int finalDisciplinaryPoint, int finalBonus, int finalPelnaty,
			int finalGpaResult) {
		super();
		this.finalAcademicMark = finalAcademicMark;
		this.finalDisciplinaryPoint = finalDisciplinaryPoint;
		this.finalBonus = finalBonus;
		this.finalPelnaty = finalPelnaty;
		this.finalGpaResult = finalGpaResult;
	}
	public int getFinalAcademicMark() {
		return finalAcademicMark;
	}
	public void setFinalAcademicMark(int finalAcademicMark) {
		this.finalAcademicMark = finalAcademicMark;
	}
	public int getFinalDisciplinaryPoint() {
		return finalDisciplinaryPoint;
	}
	public void setFinalDisciplinaryPoint(int finalDisciplinaryPoint) {
		this.finalDisciplinaryPoint = finalDisciplinaryPoint;
	}
	public int getFinalBonus() {
		return finalBonus;
	}
	public void setFinalBonus(int finalBonus) {
		this.finalBonus = finalBonus;
	}
	public int getFinalPelnaty() {
		return finalPelnaty;
	}
	public void setFinalPelnaty(int finalPelnaty) {
		this.finalPelnaty = finalPelnaty;
	}
	public int getFinalGpaResult() {
		return finalGpaResult;
	}
	public void setFinalGpaResult(int finalGpaResult) {
		this.finalGpaResult = finalGpaResult;
	}
	
	
	
}
