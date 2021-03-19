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
    public JTable table1;
    private JScrollPane scrollPane;


    public ViewCustomerAccount(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewCustomer);
        this.pack();

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
                //Need to add a GUI page for update
            }
        });
    }
}
