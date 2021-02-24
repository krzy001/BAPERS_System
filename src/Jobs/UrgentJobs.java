package Jobs;

import java.time.LocalDateTime;

public class UrgentJobs extends Job {

    // we already have deadline as parameter for job. not sure about this.
    LocalDateTime customDeadline;
    float surcharge;

    public UrgentJobs(
            int jobNo, String jobUrgency, float price, String status,
            int queuePlace, LocalDateTime deadline, String[] taskList, float subtotal) {
        super(jobNo, jobUrgency, price, status, queuePlace, deadline, taskList, subtotal);
    }

    public void prioritiesJob(){

    }

    public float calculateSurcharge(LocalDateTime deadline){
        return 0;
    }

    public LocalDateTime getCustomDeadline() {
        return customDeadline;
    }

    public void setCustomDeadline(LocalDateTime customDeadline) {
        this.customDeadline = customDeadline;
    }

    public float getSurcharge() {
        return surcharge;
    }

    /* in design diagram but we already have calculate surcharge
    public void setSurcharge(float surcharge) {
        this.surcharge = surcharge;
    }
     */

    /* not sure about this cause we already have setJobUrgency in Job class
    public void assignUrgency(){

    }

     */
}
