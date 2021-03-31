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

public class ViewPayment extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JLabel jLabelJobID;
    private JLabel jLabelCustomerID;
    private JLabel jLabelTotalAmount;
    private JLabel jLabelDate;
    private JLabel jLabelTransactionID;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddPayment;
    private JButton PaymentListButton;
    private JPanel panelViewPayment;

    public ViewPayment(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewPayment);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        PaymentListButton.setPreferredSize(new Dimension(150,30));
        btnAddPayment.setPreferredSize(new Dimension(150,30));

        try{
            String sql = "SELECT * FROM payment WHERE CustomerAccount_No = '" + system.getID() + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                jLabelTransactionID.setText(transactionID);
                jLabelTotalAmount.setText(totalAmount);
                jLabelDate.setText(date);
                jLabelJobID.setText(jobID);
                jLabelCustomerID.setText(customerID);
            }

        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        PaymentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.PaymentList);
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
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddPayment);
            }
        });
    }
}