package GUI;

import Account.CustomerAccount;
import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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


    public ViewCustomerAccount(BAPERS system, String accountID) {
        super(system);
        this.setContentPane(this.panelViewCustomer);
        this.pack();

        try{
            String sql = "SELECT * FROM customer WHERE Account_No = '" + accountID + "' ";

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
    }
}
