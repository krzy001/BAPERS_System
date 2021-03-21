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

    public void addTask(
            String description, String location, String price, String duration,
            String shift, String date, String completedBy, String jobsNO, String staffID){
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO task (Task_Description,Location,Price,Duration,Shift,Date,Completed_By,JobsJob_No,StaffStaff_ID) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,description);
            pst.setString(2,location);
            pst.setString(3,price);
            pst.setString(4,duration);
            pst.setString(5,shift);
            pst.setString(6,date);
            pst.setString(7,completedBy);
            pst.setString(8,jobsNO);
            pst.setString(9,staffID);

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


    public void backupDatabase()
    {
        String dbName = "risinggen";
        String dbUser = "root";
        String dbPass = "";
        String savePath = "dbBackup.sql";
        String executeCmd = ("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u " + dbUser + " -p" + dbPass + "  --databases " + dbName + " -r " + savePath);
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
       
    }
}


