package fa.mockproject.entity;

public class ClassData {
    private String skill;
    private int total;

    public ClassData(String skill, int total) {
        this.skill = skill;
        this.total = total;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
