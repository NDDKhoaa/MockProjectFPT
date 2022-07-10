package fa.mockproject.model;

import java.util.ArrayList;
import java.util.List;

import fa.mockproject.entity.Topic;

public class TopicDTOModel {
	public List<Topic> topics = new ArrayList<Topic>();

	
	public void addTopics(Topic topic) {
		this.topics.add(topic);
	}
	
	public TopicDTOModel() {
		super();
	}

	public TopicDTOModel(List<Topic> topics) {
		super();
		this.topics = topics;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
	
}
