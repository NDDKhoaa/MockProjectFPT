package fa.mockproject.entity.enumtype;

public enum StatusDay {
	P("P"),
	A("A"),
	E("E"),
	L("L"),
	An("An"),
	En("En"),
	Ln("Ln");

	private String string;
	
	StatusDay(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
