package GUI;

import Account.CustomerAccount;
import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ViewCustomerAccount extends Screen {
    private JPanel panelTop;
    private JPanel panelViewCustomer;
    private JButton btnAddPayment;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton btnUpdate;
    private JPanel panelBottom;
    private JPanel panelMiddle;
    private JButton btnLogout;
    private JLabel jLabelName;
    private JLabel jLabelContactName;
    private JLabel jLabelAddress;
    private JLabel jLabelPhone;
    private JLabel jLabelEmail;
    private JLabel jLabelDiscountPlan;
    private JLabel jLabelValued;
    private JButton btnTask;
    private JLabel labelLogo;
    private JButton jobListButton;
    private JButton taskListButton;
    private JButton discountButton;


    public ViewCustomerAccount(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewCustomer);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnAddPayment.setPreferredSize(new Dimension(150,30));
        btnAddJob.setPreferredSize(new Dimension(150,30));
        btnUpdate.setPreferredSize(new Dimension(150,30));
        btnTask.setPreferredSize(new Dimension(150,30));
        jobListButton.setPreferredSize(new Dimension(150,30));
        taskListButton.setPreferredSize(new Dimension(150,30));
        discountButton.setPreferredSize(new Dimension(150,30));

        try{
            String sql = "SELECT * FROM customer WHERE Account_No = '" + system.getID() + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

                String name = rs.getString(2);
                String contactName = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                String email = rs.getString(6);
                String discountPlan = rs.getString(7);
                String valued = rs.getString(8);

                jLabelName.setText(name);
                jLabelContactName.setText(contactName);
                jLabelAddress.setText(address);
                jLabelPhone.setText(phone);
                jLabelEmail.setText(email);
                jLabelDiscountPlan.setText(discountPlan);
                jLabelValued.setText(valued);

            }
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
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
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddPayment);
            }
        });
        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.UpdateCustomerInfo);
            }
        });
        btnTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobList);
            }
        });
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        discountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Discount);
            }
        });
    }
}
