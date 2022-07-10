package fa.mockproject.entity;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    private String topicName;
    
    @Column(name = "max_score", columnDefinition = "int default 0")
    private int maxScore;
    
    @Column(name = "passing_score", columnDefinition = "int default 0")
    private int passingScore;
    
    @Column(name = "weighted_number", columnDefinition = "int default 0")
    private int weightedNumber;
    
    @Column(name = "trainee_score", columnDefinition = "int default 0")
    private int traineeScore;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;
    public Topic() {
    }

   

	public Topic(long topicId, Set<LearningPath> learningPaths, Integer remarks, String topicName, int maxScore,
			int passingScore, int weightedNumber, int traineeScore, Milestone milestone) {
		super();
		this.topicId = topicId;
		this.learningPaths = learningPaths;
		this.remarks = remarks;
		this.topicName = topicName;
		this.maxScore = maxScore;
		this.passingScore = passingScore;
		this.weightedNumber = weightedNumber;
		this.traineeScore = traineeScore;
		this.milestone = milestone;
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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(int passingScore) {
		this.passingScore = passingScore;
	}

	public int getWeightedNumber() {
		return weightedNumber;
	}

	public void setWeightedNumber(int weightedNumber) {
		this.weightedNumber = weightedNumber;
	}

	public int getTraineeScore() {
		return traineeScore;
	}
	
	public void setTraineeScore(int traineeScore) {
		this.traineeScore = traineeScore;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	
	public Milestone getMilestone() {
		return milestone;
	}



	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}
    
	
    
}