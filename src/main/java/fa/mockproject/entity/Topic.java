package fa.mockproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Topic")
@Cacheable
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "topic_id", nullable = false, length = 10)
    private Integer topicId;

    @OneToMany(mappedBy="topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LearningPath> learningPathId;

    @Column(name = "remarks", length = 10)
    private Integer remarks;

    @Column(name = "topic_name", length = 10)
    private Integer topicName;

    public Topic() {
    }

    public Topic(Integer topicId, Set<LearningPath> learningPathId, Integer remarks, Integer topicName) {
        this.topicId = topicId;
        this.learningPathId = learningPathId;
        this.remarks = remarks;
        this.topicName = topicName;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Set<LearningPath> getLearningPathId() {
        return learningPathId;
    }

    public void setLearningPathId(Set<LearningPath> learningPathId) {
        this.learningPathId = learningPathId;
    }

    public Integer getRemarks() {
        return remarks;
    }

    public void setRemarks(Integer remarks) {
        this.remarks = remarks;
    }

    public Integer getTopicName() {
        return topicName;
    }

    public void setTopicName(Integer topicName) {
        this.topicName = topicName;
    }
}