package fa.mockproject.entity;

public class DashboardData {
    private String key;
    private int total;

    public DashboardData(String skill, int total) {
        this.key = skill;
        this.total = total;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
