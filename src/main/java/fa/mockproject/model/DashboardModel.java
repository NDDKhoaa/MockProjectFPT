package fa.mockproject.model;

import fa.mockproject.entity.enumtype.ClassBatchStatusEnum;

public class DashboardModel {

  private String dashboardFor;
  private String location;
  private String status;

  public DashboardModel(String dashboardFor, String location, String status) {
    this.dashboardFor = dashboardFor;
    this.location = location;
    this.status = status;
  }

  public String getDashboardFor() {
    return dashboardFor;
  }

  public void setDashboardFor(String dashboardFor) {
    this.dashboardFor = dashboardFor;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
