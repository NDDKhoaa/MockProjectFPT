package fa.mockproject.entity;


import javax.persistence.*;

@Entity
@Table(name = "LearningPath")
@Cacheable
public class LearningPath {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "learning_path_id", nullable = false)
    private long learningPathId;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate_id", nullable = false)
    private Trainee trainee;

    public LearningPath() {
    }

    public LearningPath(long learningPathId, Topic topic, Trainee trainee) {
		super();
		this.learningPathId = learningPathId;
		this.topic = topic;
		this.trainee = trainee;
	}

	public long getLearningPathId() {
        return learningPathId;
    }

    public void setLearningPathId(Integer learningPathId) {
        this.learningPathId = learningPathId;
    }

    public Topic getTopicId() {
        return topic;
    }

    public void setTopicId(Topic topic) {
        this.topic = topic;
    }

}

