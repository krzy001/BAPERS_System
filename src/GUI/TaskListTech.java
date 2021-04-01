package GUI;

import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskListTech extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JTable taskTable;
    private JPanel panelBottom;
    private JButton btnBack;
    private JCheckBox checkBox2;
    private JCheckBox checkBox1;
    private JPanel panelTaskListTech;
    private JCheckBox commencedTasksCheckBox;
    private JButton btnTaskList;

    public TaskListTech(BAPERS system) {
        super(system);
        this.setContentPane(this.panelTaskListTech);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));

        //Creating models for the checkboxes to swap between for listing tasks with certain criteria.
        DefaultTableModel model1 = new DefaultTableModel(new String[]{
                "Task ID", "Task Description", "Start Time", "Location", "Price",
                "Duration", "Shift", "Date", "Status",
                "Completed By","Job ID", "Staff ID","Time Taken"}, 0);

        DefaultTableModel model2 = new DefaultTableModel(new String[]{
                "Task ID", "Task Description","Start Time", "Location", "Price",
                "Duration", "Shift", "Date", "Status",
                "Completed By","Job ID", "Staff ID","Time Taken"}, 0);

        DefaultTableModel model3 = new DefaultTableModel(new String[]{
                "Task ID", "Task Description","Start Time", "Location", "Price",
                "Duration", "Shift", "Date", "Status",
                "Completed By","Job ID", "Staff ID","Time Taken"}, 0);

        DefaultTableModel model4 = new DefaultTableModel(new String[]{
                "Task ID", "Task Description","Start Time", "Location", "Price",
                "Duration", "Shift", "Date", "Status",
                "Completed By","Job ID", "Staff ID","Time Taken"}, 0);

        try {
            //Select all jobs from the database
            String sql = "SELECT * FROM task";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every task...
            while(rs.next())
            {
                //...variables created for each column in the row
                String taskID = rs.getString(1);
                String taskDescription = rs.getString(2);
                String startTime = rs.getString(3);
                String location = rs.getString(4);
                String price = rs.getString(5);
                String duration = rs.getString(6);
                String shift = rs.getString(7);
                String date = rs.getString(8);
                String status = rs.getString(9);
                String completedBy = rs.getString(10);
                String jobID = rs.getString(11);
                String staffID = rs.getString(12);
                String timeTaken = rs.getString(13);
                //All the variables added to a row of the model
                model1.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});
            }
            //This is the initial model that is set on the jTable to display for the user
            taskTable.setModel(model1);

        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            //Select all tasks from the database where Status = "Commenced"
            String sql = "SELECT * FROM task WHERE Status='Commenced'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every task...
            while (rs.next()) {
                //...variables created for each column in the row
                String taskID = rs.getString(1);
                String taskDescription = rs.getString(2);
                String startTime = rs.getString(3);
                String location = rs.getString(4);
                String price = rs.getString(5);
                String duration = rs.getString(6);
                String shift = rs.getString(7);
                String date = rs.getString(8);
                String status = rs.getString(9);
                String completedBy = rs.getString(10);
                String jobID = rs.getString(11);
                String staffID = rs.getString(12);
                String timeTaken = rs.getString(13);
                //All the variables added to a row of the model
                model2.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});

            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        try {
            //Select all tasks from the database where Status = "Active"
            String sql = "SELECT * FROM task WHERE Status='Active'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every task...
            while (rs.next()) {
                //...variables created for each column in the row
                String taskID = rs.getString(1);
                String taskDescription = rs.getString(2);
                String startTime = rs.getString(3);
                String location = rs.getString(4);
                String price = rs.getString(5);
                String duration = rs.getString(6);
                String shift = rs.getString(7);
                String date = rs.getString(8);
                String status = rs.getString(9);
                String completedBy = rs.getString(10);
                String jobID = rs.getString(11);
                String staffID = rs.getString(12);
                String timeTaken = rs.getString(13);
                //All the variables added to a row of the model
                model3.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});

            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        try {
            //Select all tasks from the database where Status = "Completed"
            String sql = "SELECT * FROM task WHERE Status='Completed'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every task...
            while (rs.next()) {
                //...variables created for each column in the row
                String taskID = rs.getString(1);
                String taskDescription = rs.getString(2);
                String startTime = rs.getString(3);
                String location = rs.getString(4);
                String price = rs.getString(5);
                String duration = rs.getString(6);
                String shift = rs.getString(7);
                String date = rs.getString(8);
                String status = rs.getString(9);
                String completedBy = rs.getString(10);
                String jobID = rs.getString(11);
                String staffID = rs.getString(12);
                String timeTaken = rs.getString(13);
                //All the variables added to a row of the model
                model4.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});

            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        //When pressed, system goes back by one screen, using the system's stack of history of pages
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });

        //Listeners for checkboxes. When a checkbox is selected, the corresponding model is set to be displayed for the jTable
        //All other checkboxes are unselected
        //If no checkboxes are selected, the first model with all the jobs is set to be displayed on the jTable
        commencedTasksCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commencedTasksCheckBox.setFocusable(false);
                if(commencedTasksCheckBox.isSelected()) {
                    taskTable.setModel(model2);
                    checkBox2.setSelected(false);
                    checkBox1.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setFocusable(false);
                if(checkBox1.isSelected()) {
                    taskTable.setModel(model3);
                    checkBox2.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox2.setFocusable(false);
                if(checkBox2.isSelected()) {
                    taskTable.setModel(model4);
                    checkBox1.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        btnTaskList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTaskTech);
            }
        });
    }
}
