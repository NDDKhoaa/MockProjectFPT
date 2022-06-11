package fa.mockproject.entity.enumtype;

public enum SubSubjectTypeEnum {
	Cloud("Cloud"),
	BigData("Big Data"),
	CAD("CAD"),
	CAE("CAE"),
	SAP("SAP"),
	ITGeneral("IT General"),
	Test("Test"),
	Others("Others");
	
	private String string;

	SubSubjectTypeEnum(String string) {
		this.string = string;
	}

	public String getValue() {
		return string;
	}
}
