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
    private JTable jobsTable;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddPayment;
    private JButton btnSearchPayment;
    private JPanel panelPaymentList;

    public PaymentList(BAPERS system) {
        super(system);
        this.setContentPane(this.panelPaymentList);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnSearchPayment.setPreferredSize(new Dimension(150,30));
        btnAddPayment.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model = new DefaultTableModel(new String[]{
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

                model.addRow(new Object[]{
                        transactionID, totalAmount, date, jobID,
                        customerID});
            }
            jobsTable.setModel(model);
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
        btnSearchPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchPayment);
            }
        });
    }
}
