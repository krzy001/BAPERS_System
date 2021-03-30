package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Control.BAPERS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskList extends Screen{
    private JPanel panelTaskList;
    private JPanel panelTop;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddTask;
    private JLabel labelLogo;
    private JButton btnSearchTask;

    private JTable taskTable;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;

    public TaskList(BAPERS system){
        super(system);
        this.setContentPane(this.panelTaskList);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnAddTask.setPreferredSize(new Dimension(150,30));
        btnSearchTask.setPreferredSize(new Dimension(150,30));

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

        try {
            String sql = "SELECT * FROM task";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
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
                model1.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});
            }

            taskTable.setModel(model1);

        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql = "SELECT * FROM task WHERE Status='Active'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

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
                model2.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});

            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        try {
            String sql = "SELECT * FROM task WHERE Status='Completed'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

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
                model3.addRow(new Object[]{
                        taskID, taskDescription, startTime, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID,timeTaken});

            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }


        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });

        btnAddTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
        btnSearchTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setFocusable(false);
                if(checkBox1.isSelected()) {
                    taskTable.setModel(model2);
                    checkBox2.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        btnSearchTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTask);
            }
        });
        checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox2.setFocusable(false);
                if(checkBox2.isSelected()) {
                    taskTable.setModel(model3);
                    checkBox1.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
    }
}
