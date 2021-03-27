package Report;

import database.dbConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Report {

    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost/risinggen";
    String user="root";
    String pass="";

    DefaultTableModel model;

    public Report() {
        dbConnection dbConnect = new dbConnection();
        dbConnect.DBConnectivity();
    }

    public void getIndividualPerformanceReport(){
        model = new DefaultTableModel(new String[]{
                "Name", "Task IDs", "Department", "Date",
                "Start Time", "Time Taken", "Total"}, 0);

        //While loop add somewhere for each job
        try {
            String sql = "SELECT * FROM task WHERE Job_ID="+1;
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            // Needs to be some sql code to fetch data linking tasks and jobs

            int Total = 0;
            while(rs.next())
            {
                String name = rs.getString("Completed By");
                String taskID = rs.getString("Task_ID");
                String department = rs.getString("Location");
                String date = rs.getString("Date");
                //String startTime = rs.getString("????"); /////////////// Task needs start time
                String timeTaken = rs.getString("Duration");
                Total += Integer.parseInt(timeTaken);

                model.addRow(new Object[]{
                        name, taskID, department, date,
                        //startTime,
                        timeTaken, null});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
    }


    public DefaultTableModel getModel(){
        return model;
    }

    public void generateReportAutomatically(){

    }

    public void viewReport(){

    }

    public void printReport(){

    }
}
