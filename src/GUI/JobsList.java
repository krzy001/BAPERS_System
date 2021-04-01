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

public class JobsList extends Screen{
    private JPanel panelTop;
    private JButton btnBack;
    private JButton btnAddJob;
    private JPanel panelJobsList;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton btnSearchJob;
    private JButton changeJobButton;
    private JTable jobsTable;
    private JScrollPane scrTbl;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox commencedJobsCheckBox;

    public JobsList(BAPERS system){
        super(system);
        this.setContentPane(this.panelJobsList);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnSearchJob.setPreferredSize(new Dimension(150,30));
        btnAddJob.setPreferredSize(new Dimension(150,30));

        //Creating models for the checkboxes to swap between for listing jobs with certain criteria.
        DefaultTableModel model1 = new DefaultTableModel(new String[]{
                "Job ID", "Start Time", "Priority", "Special Instructions",
                "Job Status", "Date", "Deadline", "Price",
                "Customer ID"}, 0);

        DefaultTableModel model2 = new DefaultTableModel(new String[]{
                "Job ID", "Start Time", "Priority", "Special Instructions",
                "Job Status", "Date", "Deadline", "Price",
                "Customer ID"}, 0);

        DefaultTableModel model3 = new DefaultTableModel(new String[]{
                "Job ID", "Start Time", "Priority", "Special Instructions",
                "Job Status", "Date", "Deadline", "Price",
                "Customer ID"}, 0);

        DefaultTableModel model4 = new DefaultTableModel(new String[]{
                "Job ID", "Start Time", "Priority", "Special Instructions",
                "Job Status", "Date", "Deadline", "Price",
                "Customer ID"}, 0);

        try {
            //Select all jobs from the database
            String sql = "SELECT * FROM jobs";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every job...
            while(rs.next())
            {
                //...variables created for each column in the row
                String jobID = rs.getString(1);
                String startTime = rs.getString(2);
                String priority = rs.getString(3);
                String specialInstructions = rs.getString(4);
                String jobStatus = rs.getString(5);
                String date = rs.getString(6);
                String deadline = rs.getString(7);
                String price = rs.getString(8);
                String customerID = rs.getString(9);
                //All the variables added to a row of the model
                model1.addRow(new Object[]{
                        jobID, startTime, priority, specialInstructions,
                        jobStatus, date, deadline, price, customerID});
            }
            //This is the initial model that is set on the jTable to display for the user
            jobsTable.setModel(model1);

        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            //Select all jobs from the database with job status as "Commenced"
            String sql = "SELECT * FROM jobs WHERE Job_Status='Commenced'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every job...
            while (rs.next()) {
                //...variables created for each column in the row
                String jobID = rs.getString(1);
                String startTime = rs.getString(2);
                String priority = rs.getString(3);
                String specialInstructions = rs.getString(4);
                String jobStatus = rs.getString(5);
                String date = rs.getString(6);
                String deadline = rs.getString(7);
                String price = rs.getString(8);
                String customerID = rs.getString(9);
                //All the variables added to a row of the model
                model2.addRow(new Object[]{
                        jobID, startTime, priority, specialInstructions,
                        jobStatus, date, deadline, price, customerID});
            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        try {
            //Select all jobs from the database with job status as "Active"
            String sql = "SELECT * FROM jobs WHERE Job_Status='Active'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every job...
            while (rs.next()) {
                //...variables created for each column in the row
                String jobID = rs.getString(1);
                String startTime = rs.getString(2);
                String priority = rs.getString(3);
                String specialInstructions = rs.getString(4);
                String jobStatus = rs.getString(5);
                String date = rs.getString(6);
                String deadline = rs.getString(7);
                String price = rs.getString(8);
                String customerID = rs.getString(9);
                //All the variables added to a row of the model
                model3.addRow(new Object[]{
                        jobID, startTime, priority, specialInstructions,
                        jobStatus, date, deadline, price, customerID});
            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        try {
            //Select all jobs from the database with job status as "Completed"
            String sql = "SELECT * FROM jobs WHERE Job_Status='Completed'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //For every job...
            while (rs.next()) {
                //...variables created for each column in the row
                String jobID = rs.getString(1);
                String startTime = rs.getString(2);
                String priority = rs.getString(3);
                String specialInstructions = rs.getString(4);
                String jobStatus = rs.getString(5);
                String date = rs.getString(6);
                String deadline = rs.getString(7);
                String price = rs.getString(8);
                String customerID = rs.getString(9);
                //All the variables added to a row of the model
                model4.addRow(new Object[]{
                        jobID, startTime, priority, specialInstructions,
                        jobStatus, date, deadline, price, customerID});
            }
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
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
        commencedJobsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commencedJobsCheckBox.setFocusable(false);
                if(commencedJobsCheckBox.isSelected()) {
                    jobsTable.setModel(model2);
                    checkBox2.setSelected(false);
                    checkBox1.setSelected(false);
                }
                else{
                    jobsTable.setModel(model1);
                }
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setFocusable(false);
                if(checkBox1.isSelected()) {
                    jobsTable.setModel(model3);
                    checkBox2.setSelected(false);
                    commencedJobsCheckBox.setSelected(false);
                }
                else{
                    jobsTable.setModel(model1);
                }
            }
        });
        btnSearchJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchJob);
            }
        });
        checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox2.setFocusable(false);
                if(checkBox2.isSelected()) {
                    jobsTable.setModel(model4);
                    checkBox1.setSelected(false);
                    commencedJobsCheckBox.setSelected(false);
                }
                else{
                    jobsTable.setModel(model1);
                }
            }
        });
    }
}
