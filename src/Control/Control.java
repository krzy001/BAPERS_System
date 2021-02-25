package Control;

import java.time.LocalDate;
import java.time.LocalTime;

public class Control {


    public void identifyUserAccount(){

    }

    public void createUserAccount(){

    }

    public void login(String username, String password){

    }

    public void logout(){

    }

    public void createJob(int jobNo){

    }

    public void setPrivilege(int accountID){

    }

    public void processJob(int jobNo){

    }

    public void removeUserAccount(){

    }

    public void createCustomerAccount(
            String customerName, String contactName, LocalDate dateOfBirth, String customerType,
            String email, String address){

    }

    public void assignJob(){

    }

    public void restoreDatabase(){

    }

    public void backupDatabase(){

    }

    public void applyDiscount(){

    }

    public void processPayment(){

    }

    public void recordCashPayment(){

    }

    public void recordCardPayment(){

    }

    public void printReport(int reportID){

    }

    public void viewReport(int reportID){

    }

    public void assignUrgency(){

    }

    public void recordDeadline(){

    }

    public void searchJob(int jobNo){

    }

    //Maybe the parameters could be simplified to the customer account
    public void acceptJob(
            String customerName, String contactName, LocalDate dateOfBirth, String email,
            String address){

    }

    public void updateCustomerStatus(){

    }

    public void identifyCustomerAccount(int accountID){

    }

    public void createInvoice(){

    }

    public void generateIndividualJobReport(int accountID){

    }

    public void generateIndividualPerformanceReport(int accountID){

    }

    public void generateSummaryPerformanceReport(
            LocalDate startDate, LocalDate endDate, String department, LocalTime totalTime, String shift){

    }

}
