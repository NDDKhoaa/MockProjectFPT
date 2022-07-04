package fa.mockproject.model;

import java.util.List;

public class WrapEntryTestModel {

	private List<EntryTestModel> entryTestModels;

	public WrapEntryTestModel() {
		super();
	}

	public WrapEntryTestModel(List<EntryTestModel> entryTestModels) {
		super();
		this.entryTestModels = entryTestModels;
	}

	public void addModel(EntryTestModel model) {
		this.entryTestModels.add(model);
	}

	public List<EntryTestModel> getEntryTestModels() {
		return entryTestModels;
	}

	public void setEntryTestModels(List<EntryTestModel> entryTestModels) {
		this.entryTestModels = entryTestModels;
	}

}
