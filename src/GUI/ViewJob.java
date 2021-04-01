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
    private JPanel panelViewJob;
    private JLabel jLabelJobID;
    private JLabel jLabelStartTime;
    private JLabel jLabelPriority;
    private JLabel jLabelSpecial;
    private JLabel jLabelJobStatus;
    private JLabel jLabelDate;
    private JLabel jLabelDeadline;
    private JLabel jLabelPrice;
    private JLabel jLabelAccountNo;

    public ViewJob(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewJob);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        jobListButton.setPreferredSize(new Dimension(150,30));
        btnAddJob.setPreferredSize(new Dimension(150,30));

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
                String accountNo = rs.getString(9);

                jLabelJobID.setText(jobNo);
                jLabelStartTime.setText(startTime);
                jLabelPriority.setText(priority);
                jLabelSpecial.setText(special);
                jLabelJobStatus.setText(jobStatus);
                jLabelDate.setText(date);
                jLabelDeadline.setText(deadline);
                jLabelPrice.setText(price);
                jLabelAccountNo.setText(accountNo);
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
