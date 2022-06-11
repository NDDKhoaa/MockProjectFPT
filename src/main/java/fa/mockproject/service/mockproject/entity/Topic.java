package fa.mockproject.service.mockproject.entity;

import fa.mockproject.entity.LearningPath;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Topic")
@Cacheable
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "topic_id", nullable = false)
    private long topicId;

    @OneToMany(mappedBy="topic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LearningPath> learningPaths;

    @Column(name = "remarks")
    private Integer remarks;

    @Column(name = "topic_name")
    private Integer topicName;

    public Topic() {
    }

    public Topic(Integer topicId, Set<LearningPath> learningPathId, Integer remarks, Integer topicName) {
        this.topicId = topicId;
        this.learningPaths = learningPathId;
        this.remarks = remarks;
        this.topicName = topicName;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Set<LearningPath> getLearningPaths() {
        return learningPaths;
    }

    public void setLearningPaths(Set<LearningPath> learningPathId) {
        this.learningPaths = learningPathId;
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