package fa.mockproject.entity.enumtype;

public enum TrainerTypeEnum {
	MasterTrainer ("MasterTrainer"),
	Trainer ("Trainer");
	
	private String name;
	TrainerTypeEnum(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
}