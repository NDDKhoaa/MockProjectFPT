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
    private Topic topicId;

    @ManyToOne
    @JoinColumn(name = "trainee_candidate id", nullable = false)
    private Trainee traineeId;

    public LearningPath() {
    }

    public LearningPath(Integer learningPathId, Topic topicId, Trainee traineeId) {
        this.learningPathId = learningPathId;
        this.topicId = topicId;
        this.traineeId = traineeId;
    }

    public long getLearningPathId() {
        return learningPathId;
    }

    public void setLearningPathId(Integer learningPathId) {
        this.learningPathId = learningPathId;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    public Trainee getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
    }

}

