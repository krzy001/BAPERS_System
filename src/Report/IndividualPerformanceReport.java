package Report;

import java.time.LocalDate;
import java.time.LocalTime;

public class IndividualPerformanceReport extends Report {

    String name;
    int taskID;
    String department;
    LocalDate date;
    LocalTime startTime;
    LocalTime timeTake;
    LocalTime totalTime;
    int accountID;

    public IndividualPerformanceReport() {

    }

    public void setIndividualPerformanceReport(String IndividualPerformanceReport){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getTimeTake() {
        return timeTake;
    }

    public void setTimeTake(LocalTime timeTake) {
        this.timeTake = timeTake;
    }

    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    /* These weren't in design diagram so not sure
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
     */
}
