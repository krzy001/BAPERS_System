package Report;

import java.time.LocalDate;
import java.time.LocalTime;

public class SummaryPerformanceReport extends Report {

    LocalDate startDate;
    LocalDate endDate;
    String department;
    LocalTime totalTime;
    String shift;

    public SummaryPerformanceReport(int reportID) {
        super(reportID);
    }

    public String getSummaryPerformanceReport(){
        return "Hello World";
    }

    public void setSummaryPerformanceReport(){

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
