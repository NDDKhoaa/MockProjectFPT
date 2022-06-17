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
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private Trainee traineeId;

    public LearningPath() {
    }

    public LearningPath(Integer learningPathId, Topic topic, Trainee traineeId) {
        this.learningPathId = learningPathId;
        this.topic = topic;
        this.traineeId = traineeId;
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

    public Trainee getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
    }

}

