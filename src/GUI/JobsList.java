package GUI;

import Control.BAPERS;

import javax.swing.*;
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
    private JLabel jLabelStartTime;
    private JLabel jLabelPriority;
    private JLabel jLabelSpecialInstructions;
    private JLabel jLabelJobStatus;
    private JLabel jLabelDate;
    private JLabel jLabelDeadline;
    private JLabel jLabelPrice;
    private JLabel jLabelCustomerID;

    public JobsList(BAPERS system, String jobID){
        super(system);
        this.setContentPane(this.panelJobsList);
        this.pack();

        try{
            String sql = "SELECT * FROM jobs WHERE Job_No = '" + jobID + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

                String startTime = rs.getString(2);
                String priority = rs.getString(3);
                String specialInstructions = rs.getString(4);
                String jobStatus = rs.getString(5);
                String date = rs.getString(6);
                String deadline = rs.getString(7);
                String price = rs.getString(8);
                String CustomerID = rs.getString(9);

                jLabelStartTime.setText(startTime);
                jLabelPriority.setText(priority);
                jLabelSpecialInstructions.setText(specialInstructions);
                jLabelJobStatus.setText(jobStatus);
                jLabelDate.setText(date);
                jLabelDeadline.setText(deadline);
                jLabelPrice.setText(price);
                jLabelCustomerID.setText(CustomerID);

            }
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
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
    }
}
