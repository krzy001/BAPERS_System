package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewTask extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JLabel jLabelTaskID;
    private JLabel jLabelLocation;
    private JLabel jLabelPrice;
    private JLabel jLabelDuration;
    private JLabel jLabelShift;
    private JLabel jLabelDate;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton taskListButton;
    private JPanel panelViewTask;
    private JLabel jLabelDescription;
    private JLabel jLabelCompletedBy;
    private JLabel jLabelStaffID;
    private JLabel labelCompletedBy;
    private JLabel jLabelStartTime;
    private JLabel jLabelJobNo;
    private JLabel jLabelStatus;
    private JLabel jLabelTimeTaken;

    public ViewTask(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewTask);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        taskListButton.setPreferredSize(new Dimension(150,30));
        btnAddJob.setPreferredSize(new Dimension(150,30));

        try{
            String sql = "SELECT * FROM task WHERE Task_ID = '" + system.getID() + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

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
                String jobNo = rs.getString(11);
                String staffID = rs.getString(12);
                String timeTaken  = rs.getString(13);

                jLabelTaskID.setText(taskID);
                jLabelDescription.setText(taskDescription);
                jLabelStartTime.setText(startTime);
                jLabelLocation.setText(location);
                jLabelPrice.setText(price);
                jLabelDuration.setText(duration);
                jLabelShift.setText(shift);
                jLabelDate.setText(date);
                jLabelStatus.setText(status);
                jLabelCompletedBy.setText(completedBy);
                jLabelJobNo.setText(jobNo);
                jLabelStaffID.setText(staffID);
                jLabelTimeTaken.setText(timeTaken);
            }
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
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
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
    }
}
