package Jobs;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    int taskID;
    float price;
    String department;
    LocalDateTime startTime;
    LocalTime totalTimeTaken;
    String completedBy;
    String description;
    String status;

    //In design diagram totalTimeTaken was parameter for constructor when it shouldn't have been
    public Task(int taskID, float price, String department, LocalDateTime startTime, String completedBy, String description,String status) {
        this.taskID = taskID;
        this.price = price;
        this.department = department;
        this.startTime = startTime;
        this.completedBy = completedBy;
        this.description = description;
        this.status= status;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void setTotalTimeTaken(LocalTime totalTimeTaken) {
        this.totalTimeTaken = totalTimeTaken;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status= status;
    }
}
