package Control;

import GUI.ViewCustomerAccount;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Control {
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost/risinggen";
    String user="root";
    String pass="";
    String dbName = "risigngen";

    public boolean identifyUserAccount(String accountID){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT Staff_ID FROM staff WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,accountID);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User found");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                return false;
            }
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
            return false;
        }
    }

    public void createUserAccount(
            String name, String username, String password, String jobRole,
            String email, String department){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO staff (Name,Username,Password,Job_Role,Department) values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,username);
            pst.setString(3,password);
            pst.setString(4,jobRole);
            //pst.setString(5,email);
            pst.setString(5,department);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
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

                /* Get role and return it

                sql = "SELECT * FROM staff WHERE Username="+username;
                pst = con.prepareStatement(sql);
                 */

                return system.OfficeManager;
                //return system.ShiftManager;
                //return system.Receptionist;
                //return system.Technician;

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

    public void createJob(
            String startTime, String priority, String specialInstructions, String jobStatus,
            String date, String deadline, String price, String customerAccountNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO jobs (Start_Time,Priority,Special_Instructions,Job_Status,Date,Deadline,Price,CustomerAccount_No) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,startTime);
            pst.setString(2,priority);
            pst.setString(3,specialInstructions);
            pst.setString(4,jobStatus);
            pst.setString(5,date);
            pst.setString(6,deadline);
            pst.setString(7,price);
            pst.setString(8,customerAccountNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void setPrivilege(int accountID){

    }

    public void processJob(int jobNo){

    }

    public void removeUserAccount(){

    }

    public void createCustomerAccount(
            String name, String contactName, String address, String phoneNo,
            String email, String discountPlan, String valued){

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO customer (Name,Contact_Name,Customer_Address,Phone_Number,Email,Discount_Plan,Valued_Customer) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,contactName);
            pst.setString(3,address);
            pst.setString(4,phoneNo);
            pst.setString(5,email);
            pst.setString(6,discountPlan);
            pst.setString(7,valued);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

    }

    public void assignJob(){

    }

    public void applyDiscount(){

    }

    public void processPayment(
            String customerName, String nameOnCard, String expiryDate, String lastFourDigits,
            String paid){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO payment () values ()";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,customerName);
            pst.setString(2,nameOnCard);
            pst.setString(3,expiryDate);
            pst.setString(4,lastFourDigits);
            pst.setString(5,paid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
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

    public boolean identifyCustomerAccount(String accountID){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT Account_No FROM customer WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,accountID);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Customer found");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
                return false;
            }
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
            return false;
        }
    }

    public void viewCustomerInfo(){

    }

    public void viewUserInfo(){

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

    public void backupDatabase() {
        String savePath = "dbBackup.sql";
        String executeCmd = ("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u " + user + " -p" + pass + " --databases " + dbName + " -r " + savePath);
        try {
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            if (processComplete == 0)
            {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void restoreDatabase() {
       
    }
}


