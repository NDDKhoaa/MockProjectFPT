package fa.mockproject.model;

import java.util.List;

public class WrapInterviewModel {

	private List<InterviewModel> interviewModels;

	public WrapInterviewModel() {
		super();
	}

	public WrapInterviewModel(List<InterviewModel> interviewModels) {
		super();
		this.interviewModels = interviewModels;
	}

	public void addModel(InterviewModel model) {
		this.interviewModels.add(model);
	}

	public List<InterviewModel> getInterviewModels() {
		return interviewModels;
	}

	public void setInterviewModels(List<InterviewModel> interviewModels) {
		this.interviewModels = interviewModels;
	}

}
