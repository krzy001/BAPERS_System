package Jobs;

import java.time.LocalDateTime;

public class Job {
    int jobNo;
    String jobUrgency;
    float price;
    String status;
    int queuePlace;
    LocalDateTime deadline;
    String[] taskList;
    float subtotal;

    public Job(
            int jobNo, String jobUrgency, float price, String status,
            int queuePlace, LocalDateTime deadline, String[] taskList, float subtotal){

        this.jobNo = jobNo;
        this.jobUrgency = jobUrgency;
        this.price = price;
        this.status = status;
        this.queuePlace = queuePlace;
        this.deadline = deadline;
        this.taskList = taskList;
        this.subtotal = subtotal;
    }

    public void createInvoice(){

    }

    public void updateStatus(){

    }

    public void updateQueue(){

    }

    public boolean checkValidAccount(){
        return false;
    }

    public int calculateTimeTaken(){
        return 0;
    }

    public void makePayment(float subtotal){

    }

    public int assignJob(int JobNo){
        return 0;
    }

    public double calculatePrice(double price){
        return 0.0;
    }

    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobUrgency() {
        return jobUrgency;
    }

    public void setJobUrgency(String jobUrgency) {
        this.jobUrgency = jobUrgency;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    /*This was in the design diagram but we already have update Status
    public void setStatus(String status) {
        this.status = status;
    }
     */

    public int getQueuePlace() {
        return queuePlace;
    }

    public void setQueuePlace(int queuePlace) {
        this.queuePlace = queuePlace;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    /* These weren't in the design diagram but they might get used.
    public String[] getTaskList() {
        return taskList;
    }

    public void setTaskList(String[] taskList) {
        this.taskList = taskList;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
     */
}



