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
    private JTable paymentList;
    private JCheckBox unpaidPaymentsCheckBox;
    private JCheckBox paidPaymentsCheckBox;
    private JLabel jLabelPaid;

    public ViewPayment(BAPERS system) {
        super(system);
        this.setContentPane(this.panelViewPayment);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        PaymentListButton.setPreferredSize(new Dimension(150,30));
        btnAddPayment.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model1 = new DefaultTableModel(new String[]{
                "Transaction ID", "Total Amount", "Date", "Job ID",
                "Customer ID"}, 0);

        DefaultTableModel model2 = new DefaultTableModel(new String[]{
                "Transaction ID", "Total Amount", "Date", "Job ID",
                "Customer ID"}, 0);

        DefaultTableModel model3 = new DefaultTableModel(new String[]{
                "Transaction ID", "Total Amount", "Date", "Job ID",
                "Customer ID"}, 0);

        try {
            String sql = "SELECT * FROM payment WHERE CustomerAccount_No =  '"+ system.getID() + "' ";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                model1.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
            paymentList.setModel(model1);
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }

        ///////////////////////////////////////////////////////////////////////// Model for unpaid payments

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcardpayment ON payment.Transaction_ID = recordcardpayment.PaymentTransaction_ID "+
                            "WHERE recordcardpayment.Paid = 'No' "+
                            "AND payment.CustomerAccount_No =  '"+ system.getID() + "'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                model2.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcashpayment ON payment.Transaction_ID = recordcashpayment.PaymentTransaction_ID " +
                            "WHERE recordcashpayment.Paid = 'No'" +
                            "AND payment.CustomerAccount_No =  '"+ system.getID() + "'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                model2.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }

        try {
            String sql =
                    "SELECT * FROM payment " +
                            "WHERE Transaction_ID NOT IN (SELECT PaymentTransaction_ID FROM recordcashpayment) " +
                            "AND Transaction_ID NOT IN (SELECT PaymentTransaction_ID FROM recordcardpayment)"+
                            "AND CustomerAccount_No =  '"+ system.getID() + "'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                model2.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }

        ///////////////////////////////////////////////////////////////////////// Model for paid payments

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcardpayment ON payment.Transaction_ID = recordcardpayment.PaymentTransaction_ID "+
                            "WHERE recordcardpayment.Paid = 'Yes'"+
                            "AND payment.CustomerAccount_No =  '"+ system.getID() + "'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                model3.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcashpayment ON payment.Transaction_ID = recordcashpayment.PaymentTransaction_ID "+
                            "WHERE recordcashpayment.Paid = 'Yes'"+
                            "AND payment.CustomerAccount_No =  '"+ system.getID() + "'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String transactionID = rs.getString(1);
                String totalAmount = rs.getString(2);
                String date = rs.getString(3);
                String jobID = rs.getString(4);
                String customerID = rs.getString(5);

                model3.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }

        PaymentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.PaymentList);
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
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddPayment);
            }
        });
        unpaidPaymentsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unpaidPaymentsCheckBox.setFocusable(false);
                if(unpaidPaymentsCheckBox.isSelected()) {
                    paymentList.setModel(model2);
                    paidPaymentsCheckBox.setSelected(false);
                }
                else{
                    paymentList.setModel(model1);
                }
            }
        });
        paidPaymentsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paidPaymentsCheckBox.setFocusable(false);
                if(paidPaymentsCheckBox.isSelected()) {
                    paymentList.setModel(model3);
                    unpaidPaymentsCheckBox.setSelected(false);
                }
                else{
                    paymentList.setModel(model1);
                }
            }
        });
    }
}