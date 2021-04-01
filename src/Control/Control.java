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
    //details used for accessing the database
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost/risinggen";
    String user="root";
    String pass="";

    //Used to search for a user in the database using their account ID.
    public boolean identifyUserAccount(String accountID){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "SELECT Staff_ID FROM staff WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,accountID);
            rs = pst.executeQuery();

            //If a user has been found with that account ID, true is returned so the next screen is executed to show that user's details
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User found");
                return true;
            //Otherwise, user hasn't been found. False is returned to stop the next screen from being executed since there is no details to show.
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                return false;
            }
        }
        //If an error has occurred with the database, display error and return false
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"User not found");
            return false;
        }
    }

    //Used to insert a new user (staff member) account details into the database
    public void createUserAccount(
            String name, String username, String password, String jobRole,
            String email, String department){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //insert all values into database to create a new user
            String sql = "INSERT INTO staff (Name,Username,Password,Job_Role, Email, Department) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,username);
            pst.setString(3,password);
            pst.setString(4,jobRole);
            pst.setString(5,email);
            pst.setString(6,department);

            //If everything went well, User was successfully created into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"User Created");
        }
        //If something went wrong, user couldn't be created into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"User Not Created");
        }
    }

    //Used to insert new job details into the database
    public void createJob(
            String startTime, String priority, String specialInstructions, String jobStatus,
            String date, String deadline, String price, String customerAccountNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO jobs (Start_Time,Priority,Special_Instructions,Job_Status,Date,Deadline,Price,CustomerAccount_No) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            //insert all values into database as a new job
            pst.setString(1,startTime);
            pst.setString(2,priority);
            pst.setString(3,specialInstructions);
            pst.setString(4,jobStatus);
            pst.setString(5,date);
            pst.setString(6,deadline);
            pst.setString(7,price);
            pst.setString(8,customerAccountNo);

            //If everything went well, Job was successfully added into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Job Created");
        }
        //If something went wrong, Job couldn't be added into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Job Create Unsuccessful");
        }
    }

    /*All the methods involving updating a certain attribute of an object in the database
    could've been done a lot more efficiently by just having one method to just updateewith
    GUI feeding them what object and attribute to update, but we didn't have enough time
    making this work, so we have one method for each attribute of each object to update.
     */

    //Method to update the start time of a job in the database.
    public void updateJobStartTime(String startTime,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the start time of the job where the jobID is the one entered.
            String sql = "UPDATE jobs SET Start_Time=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,startTime);
            pst.setString(2,jobNo);

            //If job ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the job ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the job status of a job in the database.
    public void updateJobStatus(String jobStatus,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "UPDATE jobs SET Job_Status=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            //updating the job status of the job where the jobID is the one entered.
            pst.setString(1,jobStatus);
            pst.setString(2,jobNo);

            //If job ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the job ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the date of a job in the database.
    public void updateDate(String date,String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the date of the job where the jobID is the one entered.
            String sql = "UPDATE jobs SET Date=? WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,date);
            pst.setString(2,jobNo);

            //If job ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the job ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }

    }

    //Method to remove a job from the database
    public void removeJob(String jobNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Searches for the job ID that was taken from the user
            String sql = "DELETE FROM jobs WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobNo);

            //If successful, all job data associated with that job ID has been removed from the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Remove Successful");
        }
        //If something went wrong (Job ID couldn't be found etc), removal from database was unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Remove Unsuccessful");
        }
    }

    //Used to insert new task details into the database
    public void addTask(
            String description,String startTime, String location, String price, String duration,
            String shift, String date, String status,String completedBy, String jobsNO, String staffID,String timeTaken){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //insert all values into database as a new task
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

            //If everything went well, the task was successfully added into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Task Added");
        }
        //If something went wrong, the task couldn't be added into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Task Not Added");
        }
    }

    //Method to update the start time of a task in the database.
    public void updateTaskStartTime(String startTime,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the start time of the task where the taskID is the one entered.
            String sql = "UPDATE task SET Start_Time=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,startTime);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update which department the task will be/is completed.
    public void updateLocation(String location,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the department is/will be completed based on the taskID that was entered.
            String sql = "UPDATE task SET Location=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,location);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the duration of time it should take to complete a task in the database.
    public void updateDuration(String duration,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the duration of the task where the taskID is the one entered.
            String sql = "UPDATE task SET Duration=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,duration);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update which shift the task will be completed in
    public void updateTaskShift(String shift,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating which shift the task with the taskID entered will take place.
            String sql = "UPDATE task SET Shift=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,shift);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the status of a task in the database
    public void updateTaskStatus(String status,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the status of the task where the taskID is the one entered.
            String sql = "UPDATE task SET Status=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,status);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update who completed a task in the database
    public void updateCompletedBy(String completedBy,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating who completed a task where the taskID is the one entered.
            String sql = "UPDATE task SET completed_By=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,completedBy);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update who completed a task in the database by their staffID
    public void updateTaskStaffId(String staffID,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating who completed a task by their staffID where the taskID is the one entered.
            String sql = "UPDATE task SET StaffStaff_Id=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,staffID);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the time it actually took to complete a task in the database.
    public void updateTaskTimeTaken(String timeTaken,String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //updating the time it took to complete the task where the taskID is the one entered.
            String sql = "UPDATE task SET Time_Taken=? WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,timeTaken);
            pst.setString(2,taskId);

            //If task ID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the task ID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to remove a task from the database
    public void removeTask(String taskId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "Delete FROM task WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,taskId);

            //If successful, all task data associated with that task ID has been removed from the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Remove Successful");
        }
        //If something went wrong (task ID couldn't be found etc), removal from database was unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Remove Unsuccessful");
        }
    }

    //Used to insert a new customer's details into the database
    public void createCustomerAccount(
            String name, String contactName, String address, String phoneNo,
            String email, String discountPlan, String valued){

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //insert all values into database to create a new customer
            String sql = "INSERT INTO customer (Name,Contact_Name,Customer_Address,Phone_Number,Email,Discount_Plan,Valued_Customer) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,contactName);
            pst.setString(3,address);
            pst.setString(4,phoneNo);
            pst.setString(5,email);
            pst.setString(6,discountPlan);
            pst.setString(7,valued);

            //If everything went well, customer was successfully added to the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Customer Account Created");
        }
        //If something went wrong, customer couldn't be added to the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Customer Account Couldn't be Created");
        }

    }

    //Method to update the name (Company name) of a customer in the database
    public void updateCustomerName(String name,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the name of a customer where their account number is the one inputted
            String sql = "UPDATE customer SET Name=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the contact name of a customer in the database
    public void updateCustomerContactName(String contactName,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the contact name of a customer where their account number is the one inputted
            String sql = "UPDATE customer SET Contact_Name=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,contactName);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the address of a customer in the database
    public void updateCustomerAddress(String address,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the address of a customer where their account number is the one inputted
            String sql = "UPDATE customer SET Customer_Address=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,address);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the phone number of a customer in the database
    public void updateCustomerPhone(String phone,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the phone number of a customer where their account number is the one inputted
            String sql = "UPDATE customer SET Phone_Number=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,phone);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the email address of a customer in the database
    public void updateCustomerEmail(String email,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the email of a customer where their account number is the one inputted
            String sql = "UPDATE customer SET Email=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,email);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the discount plan of a customer in the database
    public void updateCustomerDiscount(String discount,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the discount plan of a customer where their account number is the one inputted
            String sql = "UPDATE customer SET Discount_Plan=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,discount);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update whether the customer is valued or not in the database
    public void updateCustomerValued(String valued,String account){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update whether or not customer should be valued by using the account number inputted
            String sql = "UPDATE customer SET Valued_Customer=? WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,valued);
            pst.setString(2,account);

            //If the customerID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If the customerID wasn't found or any other error occurred, the database was updated unsuccessful
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the name of a staff member in the database
    public void updateUserName(String name,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //update the name of a staff member where their account number is the one inputted
            String sql = "UPDATE staff SET Name=? WHERE Staff_ID="+id;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);

            //If the staffID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
            //If the staffID wasn't found or any other error occurred, the database was updated unsuccessful
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }

    //Method to update the username of a staff member in the database
    public void updateUserUsername(String username,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //update the username of a staff member where their account number is the one inputted
            String sql = "UPDATE staff SET Username=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, id);

            //If the staffID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
            //If the staffID wasn't found or any other error occurred, the database was updated unsuccessful
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }

    //Method to update the password of a staff member in the database
    public void updateUserPassword(String password,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //update the password of a staff member where their account number is the one inputted
            String sql = "UPDATE staff SET Password=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, id);

            //If the staffID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
            //If the staffID wasn't found or any other error occurred, the database was updated unsuccessful
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }

    //Method to update the job role of a staff member in the database
    public void updateUserRole(String role,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //update the job role of a staff member where their account number is the one inputted
            String sql = "UPDATE staff SET Job_Role=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, role);
            pst.setString(2, id);

            //If the staffID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
            //If the staffID wasn't found or any other error occurred, the database was updated unsuccessful
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }

    //Method to update the email of a staff member in the database
    public void updateUserEmail(String email,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //update the email of a staff member where their account number is the one inputted
            String sql = "UPDATE staff SET Email=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, id);

            //If the staffID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
            //If the staffID wasn't found or any other error occurred, the database was updated unsuccessful
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }

    //Method to update the department of a staff member in the database
    public void updateUserDepartment(String department,String id){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //update the department of a staff member where their account number is the one inputted
            String sql = "UPDATE staff SET Department=? WHERE Staff_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, department);
            pst.setString(2, id);

            //If the staffID was found and everything went well, the database was successful updated
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successful");
            //If the staffID wasn't found or any other error occurred, the database was updated unsuccessful
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Update Unsuccessful");
        }
    }

    //Used to insert new payment details into the database
    public void AddPayment(
            String amount, String date, String jobNo,
            String accountNO){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //insert all values into database as a new payment
            String sql = "INSERT INTO payment (Total_Amount,Date,JobsJob_No,CustomerAccount_No) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,amount);
            pst.setString(2,date);
            pst.setString(3,jobNo);
            pst.setString(4,accountNO);

            //If everything went well, the payment was successfully updated into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Payment Added");
        }
        //If something went wrong, the payment couldn't be updated into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Payment Not Added");
        }
    }

    //Method to update the amount of money a payment is worth in the database
    public void updatePaymentAmount(String amount,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the amount the payment is worth where the transactionID of the payment is the one inputted
            String sql = "UPDATE payment SET Total_Amount=? WHERE Transaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,amount);
            pst.setString(2,transactionId);

            //If everything went well, the payment was successfully updated into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the payment couldn't be updated into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the date of a payment made in the database
    public void updatePaymentDate(String date,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the date of the payment where the transactionID of the payment is the one inputted
            String sql = "UPDATE payment SET Date=? WHERE Transaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,date);
            pst.setString(2,transactionId);

            //If everything went well, the payment was successfully updated into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the payment couldn't be updated into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method for recording a card details to make a payment or due to make a payment.
    public void recordCardPayment(
            String cardNo, String expiryDate, String name,
            String paid, String paymentTransactionId, String cvv){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //insert all values into database as a new set of card details
            String sql = "INSERT INTO recordcardpayment (Card_No,Expiry_Date,Card_Holder_Name,Paid,PaymentTransaction_ID,CVV) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cardNo);
            pst.setString(2,expiryDate);
            pst.setString(3,name);
            pst.setString(4,paid);
            pst.setString(5,paymentTransactionId);
            pst.setString(6,cvv);

            //If everything went well, the card details were successfully added into the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Card Payment Recorded");
        }
        //If something went wrong, the card details couldn't be added into the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Card Payment Couldn't be Recorded");
        }
    }

    //Method to update the card number of a customer's card details in the database
    public void updateCardCardNo(String cardNo,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the card number of a customer's card details where the transactionID of the payment is the one inputted
            String sql = "UPDATE recordcardpayment SET Card_No=? WHERE PaymentTransaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cardNo);
            pst.setString(2,transactionId);

            //If everything went well, the card details were successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the card details couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Couldn't be updated");
        }
    }

    //Method to update the expiry date of a customer's card details in the database
    public void updateCardExpiryDate(String expiryDate,String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the expiry date of a customer's card details where the transactionID of the payment is the one inputted
            String sql = "UPDATE recordcardpayment SET Expiry_Date=? WHERE PaymentTransaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,expiryDate);
            pst.setString(2,transactionId);

            //If everything went well, the card details were successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the card details couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the card holder's name of a customer's card details in the database
    public void updateCardHolderName(String name,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the card holder's name of a customer's card details where the transactionID of the payment is the one inputted
            String sql = "UPDATE recordcardpayment SET Card_Holder_Name=? WHERE PaymentTransaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,cardNo);

            //If everything went well, the card details were successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the card details couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update whether or not a payment has been made by card
    public void updateCardPaid(String paid,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update whether or not a payment was made by card where the transactionID of the payment is the one inputted
            String sql = "UPDATE recordcardpayment SET Paid=? WHERE PaymentTransaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,paid);
            pst.setString(2,cardNo);

            //If everything went well, the card details were successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the card details couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to update the CVV of a customer's card details in the database
    public void updateCardCVV(String cvv,String cardNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update the CVV of a customer's card details where the transactionID of the payment is the one inputted
            String sql = "UPDATE recordcardpayment SET CVV=? WHERE PaymentTransaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,cvv);
            pst.setString(2,cardNo);

            //If everything went well, the card details were successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the card details couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method for recording if a payment is going to be made by cash
    public void recordCashPayment(String paid, String transactionId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //insert the values into database
            String sql = "INSERT INTO recordcashpayment (Paid,PaymentTransaction_ID) values (?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,paid);
            pst.setString(2,transactionId);

            //If everything went well, the record was successfully added to the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cash Payment Recorded");
        }
        //If something went wrong, the record couldn't be added to the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Cash Payment Couldn't be Recorded");
        }

    }

    //Method to update whether or not a payment has been made by cash
    public void updateCashPaymentPaid(String paid, String transactionID){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //update whether or not a payment was made by cash where the transactionID of the payment is the one inputted
            String sql = "UPDATE recordcashpayment SET Paid=? WHERE PaymentTransaction_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,paid);
            pst.setString(2,transactionID);

            //If everything went well, the record were successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the record couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Add a discount rate that a customer gets into the database
    public void addDiscount(String rate, String accountNo){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Discount rate is added based on the customer's account ID
            String sql = "INSERT INTO discount (DiscountRate,CustomerAccount_No) values (?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,rate);
            pst.setString(2,accountNo);

            //If everything went well, the discount rate was successfully added to the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Discount Added Successfully");
        }
        //If something went wrong, the discount rate couldn't be added to the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Discount Not Added");
        }
    }

    //Update the discount rate of an existing discount plan for a customer
    public void updateRate(String rate, String discountId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Discount rate is updated based on the discount ID
            String sql = "UPDATE discount SET DiscountRate=? WHERE Discount_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,rate);
            pst.setString(2,discountId);

            //If everything went well, the discount rate was successfully updated in the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successful");
        }
        //If something went wrong, the discount rate couldn't be updated in the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Update Unsuccessful");
        }
    }

    //Method to remove a discount from a customer and database
    public void removeDiscount(String discountId){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "DELETE FROM discount WHERE Discount_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,discountId);

            //If successful, all discount data associated with that discount ID has been removed from the database
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Remove Successful");
        }
        //If unsuccessful, all discount data associated with that discount ID couldn't be removed from the database
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Remove Unsuccessful");
        }
    }

    //Used to search for a payment in the database using a customer's account ID.
    public boolean searchPayment(String accountID){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Find the details of a payment using a customer's accountID
            String sql1 = "SELECT CustomerAccount_No FROM payment WHERE CustomerAccount_No=?";
            PreparedStatement pst = con.prepareStatement(sql1);
            pst.setString(1,accountID);
            rs = pst.executeQuery();

            if (rs.next()) {
                //If a customer has been found with that account ID, true is returned so the next screen is executed to show a payment's details.
                JOptionPane.showMessageDialog(null, "Payment Found");
                return true;
            } else {
                //If a customer couldn't be found with that account ID, false is returned so the next screen can't be executed.
                JOptionPane.showMessageDialog(null, "Payment Not Found");
                return false;
            }
        }
        catch(Exception e1){
            //If an error has occurred with the database, display error and return false
            JOptionPane.showMessageDialog(null,"Error Occurred");
            return false;
        }
    }

    //Used to search for a customer in the database using their account ID.
    public boolean identifyCustomerAccount(String accountID){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Find the details of a customer using their accountID
            String sql = "SELECT Account_No FROM customer WHERE Account_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,accountID);
            rs = pst.executeQuery();

            //If a customer has been found with that account ID, true is returned so the next screen is executed to show that customer's details
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Customer Found");
                return true;
            //Otherwise, user hasn't been found. False is returned to stop the next screen from being executed since there is no details to show.
            } else {
                JOptionPane.showMessageDialog(null, "Customer Not Found");
                return false;
            }
        }
        //If an error has occurred with the database, display error and return false
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
            return false;
        }
    }

    //Used to search for a job in the database using a job ID.
    public boolean searchJob(String jobNo){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Find the details of a job using a jobID
            String sql = "SELECT Job_No FROM jobs WHERE Job_No=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,jobNo);

            rs = pst.executeQuery();
            //If a job has been found with that job ID, true is returned so the next screen is executed to show that job's details
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Job Found");
                return true;
            } else {
                //Otherwise, job hasn't been found. False is returned to stop the next screen from being executed since there is no details to show.
                JOptionPane.showMessageDialog(null, "Job Not Found");
                return false;
            }
        }
        //If an error has occurred with the database, display error and return false
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
            return false;
        }
    }

    //Used to search for a task in the database using a task ID.
    public boolean searchTask(String taskId){
        ResultSet rs=null;
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            //Find the details of a task using a taskID
            String sql = "SELECT Task_ID FROM task WHERE Task_ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,taskId);

            rs = pst.executeQuery();
            //If a job has been found with that job ID, true is returned so the next screen is executed to show that job's details
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Task Found");
                return true;
            } else {
                //Otherwise, task hasn't been found. False is returned to stop the next screen from being executed since there is no details to show.
                JOptionPane.showMessageDialog(null, "Task Not Found");
                return false;
            }
        }
        //If an error has occurred with the database, display error and return false
        catch(Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
            return false;
        }
    }

    //Method to back up the database
    public void backupDatabase()
    {
        //String for a command to find the .bat file used to back up the database
        String executeCmd = ("cmd /c start C:\\TeamProject\\BAPERS_System\\backup.bat");
        //String executeCmd = ("cmd /c start C:\\Users\\SHAJE\\Documents\\IN2018\\BAPERS_System\\backup2.bat");
        try {
            //Execute the command
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            //If the backup was successfully created, the message "Backup Successful" is displayed
            if (processComplete == 0)
            {
                JOptionPane.showMessageDialog(null, "Backup Successful");
            }else{
                //Otherwise the message "Backup Unsuccessful" is displayed
                JOptionPane.showMessageDialog(null, "Backup Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to recover the database
    public void restoreDatabase() {
        //String executeCmd = ("cmd /c start C:\\Users\\SHAJE\\Documents\\IN2018\\BAPERS_System\\restore.bat");
        String executeCmd = ("cmd /c start C:\\TeamProject\\BAPERS_System\\restore.bat");
        try {
            Process p = Runtime.getRuntime().exec(executeCmd);
            int processComplete = p.waitFor();
            //If the recovery was successfully created, the message "Recovery Successful" is displayed
            if (processComplete == 0)
            {
                JOptionPane.showMessageDialog(null, "Recovery Successful");
            }else{
                //Otherwise the message "Recovery Unsuccessful" is displayed
                JOptionPane.showMessageDialog(null, "Recovery Unsuccessful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


