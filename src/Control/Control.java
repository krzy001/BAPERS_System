package Control;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;

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
            JOptionPane.showMessageDialog(null,"User Created");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"User Not Created");
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
            JOptionPane.showMessageDialog(null,"Job Created");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Job Created");
        }
    }

    public void updateJobStartTime(String startTime,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Start_Time=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,startTime);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    public void updateJobAccountNo(String accountNo,String jobNo) {
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE jobs SET CustomerAccount_NO=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, accountNo);
            pst.setString(2, jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }
    public void removeJob(String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "DELETE FROM jobs WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Remove Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Remove Unsuccessful");
        }
    }
    /*public void updateCustomerAccount(String customerAccountNo,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET CustomerAccount_No=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,customerAccountNo);
            pst.setString(2,jobNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }

    }*/

    public void addTask(
            String description,String startTime, String location, String price, String duration,
            String shift, String date, String status,String completedBy, String jobsNO, String staffID,String timeTaken){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO task (Task_Description,Start_Time,Location,Price,Duration,Shift,Date,Status,Completed_By,JobsJob_No,StaffStaff_ID,Time_Taken) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,description);
            pst.setString(2,startTime);
            pst.setString(3,location);
            pst.setString(4,price);
            pst.setString(5,duration);
            pst.setString(6,shift);
            pst.setString(7,date);
            pst.setString(8,status);
            pst.setString(9,completedBy);
            pst.setString(10,jobsNO);
            pst.setString(11,staffID);
            pst.setString(12,timeTaken);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Task Added");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Task Not Added");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    public void updateTaskStartTime(String startTime,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Start_Time=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,startTime);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }
    public void updateTaskTimeTaken(String timeTaken,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE task SET Time_Taken=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,timeTaken);
            pst.setString(2,taskId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Remove Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Remove Unsuccessful");
        }
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
            JOptionPane.showMessageDialog(null,"Customer Account Created");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Customer Account Not Created");
        }

    }

    public void updateCustomerName(String name,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE customer SET Name=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,account);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    public void updateUserName(String name,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE staff SET Name=? WHERE Staff_ID="+id;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
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
            JOptionPane.showMessageDialog(null, "Update Successful");
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
            JOptionPane.showMessageDialog(null, "Update Successful");
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
            JOptionPane.showMessageDialog(null, "Update Successful");
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
            JOptionPane.showMessageDialog(null, "Update Successful");
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
            JOptionPane.showMessageDialog(null, "Update Successful");
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
            JOptionPane.showMessageDialog(null,"Payment Added");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Payment Not Added");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Card Payment Recorded");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Card Payment Not Recorded");
        }
    }

    /*public void updateCardCardNo(String cardNo,String primaryCardNo){
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
    }*/
    public void updateCardExpiryDate(String expiryDate,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE recordcardpayment SET Expiry_Date=? WHERE Card_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,expiryDate);
            pst.setString(2,transactionId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Cash Payment Recorded");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Cash Payment Not Recorded");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
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
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    public void addDiscount(String rate, String accountNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO discount (DiscountRate,CustomerAccount_No) values (?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,rate);
            pst.setString(2,accountNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Discount Added Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Discount Not Added");
        }
    }

    public void updateRate(String rate, String discountId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE discount SET DiscountRate=? WHERE Discount_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,rate);
            pst.setString(2,discountId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsccessful");
        }

    }
    public void updateAccountNo(String accountNo, String discountId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE discount SET CustomerAccount_No=? WHERE Discount_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,accountNo);
            pst.setString(2,discountId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }

    }
    public void removeDiscount(String discountId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "DELETE FROM discount WHERE Discount_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,discountId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Remove Successful");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Remove Unsuccessful");
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
                JOptionPane.showMessageDialog(null, "Customer Found");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Customer Not Found");
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
                JOptionPane.showMessageDialog(null, "Job Found");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Job Not Found");
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
                JOptionPane.showMessageDialog(null, "Task Found");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Task Not Found");
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
        //String executeCmd = ("C:\\xxamp\\mysql\\bin\\mysqldump -uroot risinggen > D:\\Backup\\risinggen.sql");
        String executeCmd = ("cmd /c start C:\\xampp\\mysql\\bin\\backup.bat");
        try {
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            if (processComplete == 0)
            {
                System.out.println("Backup Successful");
            }else{
                System.out.println("Backup Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void restoreDatabase() {
        String executeCmd = ("cmd /c start C:\\xxamp\\mysql\\bin\\restore.bat");
        //String executeCmd = ("C:\\xxamp\\mysql\\bin\\mysqldump -uroot risinggen < D:\\Backup\\risinggen.sql");
        try {
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            if (processComplete == 0)
            {
                System.out.println("Restore Successful");
            }else{
                System.out.println("Restore Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*    public void IndividualPerformanceReport(){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT staff.Name,task.Task_ID,staff.Department,task.Date,task.Start_Time,task.Time_Taken FROM task INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID";
            PreparedStatement pst = (PreparedStatement) con.createStatement();
            ResultSet rs = pst.executeQuery(sql);

            Workbook w = new XSSFWorkbook();

            Sheet s = w.createSheet("Individual Performance Report");
            String[] headers = {"Name", "Task Id", "Department", "Date", "Start Time", "Time Taken"};
            ArrayList<String> Name = new ArrayList<>();

            Row row = s.createRow(0);
//            pst.setString(1,taskId);
            while (rs.next()) {
                System.out.println("Working");
                System.out.println(rs.getString(1));

//                int rowNum = 1;
               *//* for(int i = 0; i < Date.size(); ++i){
                    row = s.createRow(rowNum++);
                    row.createCell(0).setCellValue(Date.get(i));
                    getData("Day Shift 1",row.getCell(0));
                    row.createCell(1).setCellValue(Time.get(0));
                    row.createCell(2).setCellValue(Time.get(1));
                    row.createCell(3).setCellValue(Time.get(2));
                    row.createCell(4).setCellValue(Time.get(3));
                }*//*

                for (int i = 0; i < headers.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(headers[i]);


                    FileOutputStream file = new FileOutputStream(new File("Individual Performance Report.xlsx"));
                    w.write(file);
                    file.close();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
}


