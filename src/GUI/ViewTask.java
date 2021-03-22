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
    private JLabel jLabelDescription;
    private JLabel jLabelLocation;
    private JLabel jLabelPrice;
    private JLabel jLabelDuration;
    private JLabel jLabelShift;
    private JLabel jLabelDate;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton taskListButton;
    private JButton changeButton;
    private JButton removeButton;
    private JPanel panelViewTask;
    private JLabel jLabelJobNo;
    private JLabel jLabelCompletedBy;
    private JLabel jLabelStaffID;
    private JButton completeButton;

    public ViewTask(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewTask);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        try{
            String sql = "SELECT * FROM tasks WHERE Task_ID = '" + system.getID() + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

                String taskID = rs.getString(1);
                String taskDescription = rs.getString(2);
                String location = rs.getString(3);
                String price = rs.getString(4);
                String duration = rs.getString(5);
                String shift = rs.getString(6);
                String date = rs.getString(7);
                String completedBy = rs.getString(8);
                String jobID = rs.getString(9);
                String staffID = rs.getString(10);

                jLabelTaskID.setText(taskID);
                jLabelDescription.setText(taskDescription);
                jLabelLocation.setText(location);
                jLabelPrice.setText(price);
                jLabelDuration.setText(duration);
                jLabelShift.setText(shift);
                jLabelDate.setText(date);
                jLabelCompletedBy.setText(completedBy);
                jLabelJobNo.setText(jobID);
                jLabelStaffID.setText(staffID);
            }
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
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
