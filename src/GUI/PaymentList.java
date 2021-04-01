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

public class PaymentList extends Screen{

    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JScrollPane scrTbl;
    private JTable paymentTable;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddPayment;
    private JButton btnSearchPayment;
    private JPanel panelPaymentList;
    private JCheckBox unpaidPaymentsCheckBox;
    private JCheckBox paidPaymentsCheckBox;

    public PaymentList(BAPERS system) {
        super(system);
        this.setContentPane(this.panelPaymentList);
        this.pack();
        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnSearchPayment.setPreferredSize(new Dimension(150,30));
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
            String sql = "SELECT * FROM payment";
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
            paymentTable.setModel(model1);
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        ///////////////////////////////////////////////////////////////////////// Model for unpaid payments

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcardpayment ON payment.Transaction_ID = recordcardpayment.PaymentTransaction_ID "+
                            "WHERE recordcardpayment.Paid = 'No'";
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
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcashpayment ON payment.Transaction_ID = recordcashpayment.PaymentTransaction_ID " +
                            "WHERE recordcashpayment.Paid = 'No'";
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
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql =
                    "SELECT * FROM payment " +
                            "WHERE Transaction_ID NOT IN (SELECT PaymentTransaction_ID FROM recordcashpayment) " +
                            "AND Transaction_ID NOT IN (SELECT PaymentTransaction_ID FROM recordcardpayment)";
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
            JOptionPane.showMessageDialog(null,e1);
        }

        ///////////////////////////////////////////////////////////////////////// Model for paid payments

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcardpayment ON payment.Transaction_ID = recordcardpayment.PaymentTransaction_ID "+
                            "WHERE recordcardpayment.Paid = 'Yes'";
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
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql =
                    "SELECT payment.Transaction_ID, payment.Total_amount, payment.Date,payment.JobsJob_No, payment.CustomerAccount_No " +
                            "FROM payment " +
                            "INNER JOIN recordcashpayment ON payment.Transaction_ID = recordcashpayment.PaymentTransaction_ID "+
                            "WHERE recordcashpayment.Paid = 'Yes'";
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
            JOptionPane.showMessageDialog(null,e1);
        }

        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddPayment);
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
        btnSearchPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchPayment);
            }
        });
        unpaidPaymentsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unpaidPaymentsCheckBox.setFocusable(false);
                if(unpaidPaymentsCheckBox.isSelected()) {
                    paymentTable.setModel(model2);
                    paidPaymentsCheckBox.setSelected(false);
                }
                else{
                    paymentTable.setModel(model1);
                }
            }
        });
        paidPaymentsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paidPaymentsCheckBox.setFocusable(false);
                if(paidPaymentsCheckBox.isSelected()) {
                    paymentTable.setModel(model3);
                    unpaidPaymentsCheckBox.setSelected(false);
                }
                else{
                    paymentTable.setModel(model1);
                }
            }
        });
    }
}
