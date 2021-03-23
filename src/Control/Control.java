package Control;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Control {
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost/risinggen";
    String user="root";
    String pass="";


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
            String sql = "INSERT INTO staff (Name,Username,Password,Job_Role, Email, Department) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,username);
            pst.setString(3,password);
            pst.setString(4,jobRole);
            pst.setString(5,email);
            pst.setString(6,department);

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

    public void updateStartTime(String startTime,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs Start_Time=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,startTime);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updatePriority(String priority,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Priority=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,priority);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateSpecialInstruction(String specialInstructions,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Special_Instructions=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,specialInstructions);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }
    public void updateJobStatus(String jobStatus,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Job_Status WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobStatus);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }
    public void updateDate(String date,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Date=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,date);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }
    public void updateDeadline(String deadline,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Deadline=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,deadline);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }
    public void updatePrice(String price,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Price=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,price);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }
    public void removeJob(String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "Delete FROM jobs WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateCustomerAccount(String customerAccountNo,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET CustomerAccount_No=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,customerAccountNo);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }

    public void addTask(
            String description, String location, String price, String duration,
            String shift, String date, String completedBy, String jobsNO, String staffID, String status){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO task (Task_Description,Location,Price,Duration,Shift,Date,Status,Completed_By,JobsJob_No,StaffStaff_ID) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,description);
            pst.setString(2,location);
            pst.setString(3,price);
            pst.setString(4,duration);
            pst.setString(5,shift);
            pst.setString(6,date);
            pst.setString(7,status);
            pst.setString(8,completedBy);
            pst.setString(9,jobsNO);
            pst.setString(10,staffID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }
    public void updateDescription(String description,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Task_Description=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,description);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }

    public void updateLocation(String location,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Location=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,location);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }

    public void updateTaskPrice(String price,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Price=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,price);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateDuration(String duration,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Duration=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,duration);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateTaskShift(String shift,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Shift=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,shift);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateTaskDate(String date,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Date=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,date);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateTaskStatus(String status,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Status=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,status);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateCompletedBy(String completedBy,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET completed_By=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,completedBy);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateTaskJobsNo(String jobsNo,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET JobsJob_No=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobsNo);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateTaskStaffId(String staffID,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET StaffStaff_Id=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,staffID);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void removeTask(String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "Delete FROM task WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
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
    //Update the whole row of information
    /*public void updateCustomerInfo(
            String name, String contactName, String address, String phoneNo,
            String email, String discountPlan, String valued,String account){

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Name=?,Contact_Name=?,Customer_Address=?,Phone_Number=?,Email=?,Discount_Plan=?,Valued_Customer=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,contactName);
            pst.setString(3,address);
            pst.setString(4,phoneNo);
            pst.setString(5,email);
            pst.setString(6,discountPlan);
            pst.setString(7,valued);
            pst.setString(8,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }

    }*/

    public void updateCustomerName(String name,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Name=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }

    public void updateCustomerContactName(String contactName,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Contact_Name=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,contactName);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }

    public void updateCustomerAddress(String address,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Customer_Address=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,address);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }

    public void updateCustomerPhone(String phone,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Phone_Number=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,phone);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateCustomerEmail(String email,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Email=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,email);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateCustomerDiscount(String discount,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Discount_Plan=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,discount);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    public void updateCustomerValued(String valued,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Valued_Customer=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,valued);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Save Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Save Unsuccessful");
        }
    }
    /*public void updateUserInfo(
            String name, String username, String password, String role,
            String email, String department, String id) {

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Name=?,Username=?,Password=?,Job_Role=?,Email=?,Department=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, role);
            pst.setString(5, email);
            pst.setString(6, department);
            pst.setString(7, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }*/
    public void updateUserName(String name,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Name=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void updateUserUsername(String username,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Username=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void updateUserPassword(String password,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Password=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void updateUserRole(String role,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Job_Role=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, role);
            pst.setString(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void updateUserEmail(String email,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Email=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void updateUserDepartment(String department,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Department=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, department);
            pst.setString(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void assignJob(){

    }

    public void applyDiscount(){

    }
    public void AddPayment(
            String amount, String date, String jobNo,
            String accountNO){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO payment (Total_Amount,Date,JobsJob_No,CustomerAccount_No) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,amount);
            pst.setString(2,date);
            pst.setString(3,jobNo);
            pst.setString(4,accountNO);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }
    public void updatePaymentAmount(String amount,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE payment SET Total_Amount=? WHERE Transaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,amount);
            pst.setString(2,transactionId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updatePaymentDate(String date,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE payment SET Date=? WHERE Transaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,date);
            pst.setString(2,transactionId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updatePaymentJobNo(String jobNo,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE payment SET JobsJob_No=? WHERE Transaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobNo);
            pst.setString(2,transactionId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updatePaymentAccountNo(String accountNo,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE payment SET CustomerAccount_No=? WHERE Transaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,accountNo);
            pst.setString(2,transactionId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void recordCardPayment(
            String cardNo, String expiryDate, String name,
            String paid, String paymentTransactionId, String cvv){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO recordcardpayment (Card_No,Expiry_Date,Card_Holder_Name,Paid,PaymentTransaction_ID,CVV) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,expiryDate);
            pst.setString(3,cardNo);
            pst.setString(4,paid);
            pst.setString(5,paymentTransactionId);
            pst.setString(6,cvv);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updateCardCardNo(String cardNo,String primaryCardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET Card_No=? WHERE Card_No";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cardNo);
            pst.setString(2,primaryCardNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }
    public void updateCardExpiryDate(String expiryDate,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET Expiry_Date=? WHERE Card_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,expiryDate);
            pst.setString(2,transactionId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }
    public void updateCardHolderName(String name,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET Card_Holder_Name=? WHERE Card_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,cardNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updateCardPaid(String paid,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET Paid=? WHERE Card_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,paid);
            pst.setString(2,cardNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updateCardPaymentTransaction(String transactionId,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET PaymentTransaction_ID=? WHERE Card_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,transactionId);
            pst.setString(2,cardNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }
    public void updateCardCVV(String cvv,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET CVV=? WHERE Card_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cvv);
            pst.setString(2,cardNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void recordCashPayment(String paymentNo, String paid, String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO recordcashpayment (Payment_No,Paid,PaymentTransaction_ID) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,paymentNo);
            pst.setString(2,paid);
            pst.setString(3,transactionId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

    }

    public void updateCashPaymentPaid(String paid, String paymentNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcashpayment SET Paid=? WHERE Payment_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,paid);
            pst.setString(2,paymentNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }

    public void updateCashPaymentTransaction(String transactionId, String paymentNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcashpayment SET PaymentTransaction_ID=? WHERE Payment_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,transactionId);
            pst.setString(2,paymentNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
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

    public boolean searchJob(String jobNo){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT Job_No FROM jobs WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobNo);

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

    public boolean searchTask(String taskId){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT Task_ID FROM task WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,taskId);

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


    public void backupDatabase()
    {
        /*String dbName = "risinggen";
        String dbUser = "root";
        String dbPass = "";
        String savePath = "risinggen.sql";*/

        //String executeCmd = ("C:\\xxamp\\mysql\\bin\\mysqldump -u root -p risinggen > risinggen.sql");
        String executeCmd = ("cmd /c start C:\\xxamp\\mysql\\bin\\backup2.bat");
        try {
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            if (processComplete == 0)
            {
                System.out.println("Backup Created Success");
            }else{
                System.out.println("Backup Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void restoreDatabase() {
        String executeCmd = ("cmd /c start C:\\xxamp\\mysql\\bin\\restore.bat");
        //String executeCmd = ("cmd /c start C:\\xxamp\\mysql\\bin\\backup.bat");
        try {
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            if (processComplete == 0)
            {
                System.out.println("Backup Created Success");
            }else{
                System.out.println("Backup Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


