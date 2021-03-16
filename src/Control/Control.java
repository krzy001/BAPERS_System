package Control;
import GUI.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class Control {
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost/risinggen";
    String user="root";
    String pass="";

    public void identifyUserAccount(){

    }

    public void createUserAccount(){

    }

    public String login(BAPERS system, String username, String password){
        ResultSet rs=null;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM staff WHERE Username=? AND Password =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username & Password Correct");

                //how do you get role?

                return "OM";
                //return "SM";
                //return "R";
                //return "T";

            } else {
                JOptionPane.showMessageDialog(null, "Username & Password Incorrect");
                return system.getRoleLoggedIn();
            }
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
            return system.getRoleLoggedIn();
        }
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


