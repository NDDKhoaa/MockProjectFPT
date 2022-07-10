package fa.mockproject.entity.enumtype;

public enum TopicStatus {
	ASQL("ASQL"),
	BTJBT1("BTJB-Test1"),
	BTJBT2E("BTJB-Test2"),
	JDBC("JDBC"),
	ORM("ORM"),
	Web("Web"),
	Spring("Spring");

	private String string;
	
	private TopicStatus(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
