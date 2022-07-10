package fa.mockproject.entity.enumtype;

public enum AllowanceGroupEnum {
	DevN("Dev-N"),
	DevJ("Dev-J"),
	DevC("Dev-C"),
	DevP("Dev-P"),
	DevE("Dev-E");

	private String string;
	
	AllowanceGroupEnum(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
