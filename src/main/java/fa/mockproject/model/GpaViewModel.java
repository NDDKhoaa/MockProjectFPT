package fa.mockproject.model;

public class GpaViewModel {
	private long milestoneId;
	private String milestoneName;
	private int academicMark;
	private int disciplinaryPoint;
	private int bonus;
	private int pelnaty;
	private int gpaResult;
	public GpaViewModel() {
		super();
	}
	public GpaViewModel(long milestoneId, String milestoneName, int academicMark, int disciplinaryPoint, int bonus,
			int pelnaty, int gpaResult) {
		super();
		this.milestoneId = milestoneId;
		this.milestoneName = milestoneName;
		this.academicMark = academicMark;
		this.disciplinaryPoint = disciplinaryPoint;
		this.bonus = bonus;
		this.pelnaty = pelnaty;
		this.gpaResult = gpaResult;
	}
	public long getMilestoneId() {
		return milestoneId;
	}
	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}
	public String getMilestoneName() {
		return milestoneName;
	}
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	public int getAcademicMark() {
		return academicMark;
	}
	public void setAcademicMark(int academicMark) {
		this.academicMark = academicMark;
	}
	public int getDisciplinaryPoint() {
		return disciplinaryPoint;
	}
	public void setDisciplinaryPoint(int disciplinaryPoint) {
		this.disciplinaryPoint = disciplinaryPoint;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getPelnaty() {
		return pelnaty;
	}
	public void setPelnaty(int pelnaty) {
		this.pelnaty = pelnaty;
	}
	public int getGpaResult() {
		return gpaResult;
	}
	public void setGpaResult(int gpaResult) {
		this.gpaResult = gpaResult;
	}
	@Override
	public String toString() {
		return "GpaViewModel [milestoneId=" + milestoneId + ", milestoneName=" + milestoneName + ", academicMark="
				+ academicMark + ", disciplinaryPoint=" + disciplinaryPoint + ", bonus=" + bonus + ", pelnaty="
				+ pelnaty + ", gpaResult=" + gpaResult + "]";
	}
	
	
}
