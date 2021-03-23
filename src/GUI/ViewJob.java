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

public class ViewJob extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton jobListButton;
    private JButton changeButton;
    private JButton removeButton;
    private JPanel panelViewJob;
    private JLabel jLabelJobID;
    private JLabel jLabelStartTime;
    private JLabel jLabelPriority;
    private JLabel jLabelSpecial;
    private JLabel jLabelJobStatus;
    private JLabel jLabelDate;
    private JLabel jLabelDeadline;
    private JLabel jLabelPrice;
    private JLabel jLabelCustomerID;

    public ViewJob(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewJob);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        try{
            String sql = "SELECT * FROM jobs WHERE Job_No = '" + system.getID() + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

                String jobNo = rs.getString(1);
                String startTime = rs.getString(2);
                String priority = rs.getString(3);
                String special = rs.getString(4);
                String jobStatus = rs.getString(5);
                String date = rs.getString(6);
                String deadline = rs.getString(7);
                String price = rs.getString(8);
                String CustomerID = rs.getString(9);

                jLabelJobID.setText(jobNo);
                jLabelStartTime.setText(startTime);
                jLabelPriority.setText(priority);
                jLabelSpecial.setText(special);
                jLabelJobStatus.setText(jobStatus);
                jLabelDate.setText(date);
                jLabelDeadline.setText(deadline);
                jLabelPrice.setText(price);
                jLabelCustomerID.setText(CustomerID);
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
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobList);
            }
        });
        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
    }
}