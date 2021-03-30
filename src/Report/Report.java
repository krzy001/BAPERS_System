package Report;

import Control.BAPERS;
import database.dbConnection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;

public class Report {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost/risinggen";
    String user = "root";
    String pass = "";

    DefaultTableModel model;
    double discountRate = 1;

    public Report() {
        dbConnection dbConnect = new dbConnection();
        dbConnect.DBConnectivity();
    }

    public void getIndividualPerformanceReport(BAPERS system) {
        model = new DefaultTableModel(new String[]{
                "Name", "Task IDs", "Department", "Date",
                "Start Time", "Time Taken"}, 0);

        //While loop add somewhere for each job
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT staff.Name,task.Task_ID,staff.Department,task.Date,task.Start_Time,task.Time_Taken FROM task INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);


            while (rs.next()) {
                String name = rs.getString(1);
                String taskId = rs.getString(2);
                String department = rs.getString(3);
                String date = rs.getString(4);
                String startTime = rs.getString(5);
                String timeTaken = rs.getString(6);


                model.addRow(new Object[]{
                        name, taskId, department, date,
                        startTime, timeTaken});
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void getSummaryReport(BAPERS system) {
        model = new DefaultTableModel(new String[]{
                "Date", "Copy Room", "Development", "Finishing",
                "Packing"}, 0);

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT staff.Name,task.Task_ID,staff.Department,task.Date,task.Start_Time,task.Time_Taken FROM task INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);


            while (rs.next()) {
                String name = rs.getString(1);
                String taskId = rs.getString(2);
                String department = rs.getString(3);
                String date = rs.getString(4);
                String startTime = rs.getString(5);
                String timeTaken = rs.getString(6);

                model.addRow(new Object[]{
                        name, taskId, department, date,
                        startTime, timeTaken});
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void getCustomerSalesReport(BAPERS system) {
        model = new DefaultTableModel(new String[]{
                "Task ID", "Price"}, 0);

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT task.Task_ID,task.Price FROM task INNER JOIN jobs ON task.JobsJob_No = jobs.Job_No WHERE Job_No = " + system.getID();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);

            double subTotal = 0;
            getDiscountRate(system);

            while (rs.next()) {
                String taskID = rs.getString(1);
                double price = rs.getDouble(2);

                subTotal += price;

                model.addRow(new Object[]{
                        taskID, price});
            }

            double total = subTotal *discountRate* 1.2;

            model.addRow(new Object[]{
                    "Sub-Total", subTotal});

            model.addRow(new Object[]{
                    "Discount agreed", discountRate});

            model.addRow(new Object[]{
                    "Total payable (VAT at 20%)", String.format("%.2f", total)});

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void generateReportAutomatically() {

    }

    public void getDiscountRate(BAPERS system) {
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = ("SELECT\n" +
                    "  discount.DiscountRate\n" +
                    "FROM jobs\n" +
                    "  INNER JOIN customer\n" +
                    "    ON jobs.CustomerAccount_No = customer.Account_No\n" +
                    "  INNER JOIN discount\n" +
                    "    ON discount.CustomerAccount_No = customer.Account_No\n" +
                    "WHERE Job_No = " + system.getID());
            PreparedStatement st = con.prepareStatement(query);
            ResultSet data = st.executeQuery(query);

            while (data.next()) {
                discountRate = data.getDouble(1);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

