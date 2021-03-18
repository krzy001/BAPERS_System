package GUI;

import Account.CustomerAccount;
import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ViewCustomerAccount extends Screen{
    private JPanel panelTop;
    private JPanel panelViewCustomer;
    private JButton btnAddPayment;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton btnUpdate;
    private JPanel panelBottom;
    private JPanel panelMiddle;
    private JButton btnLogout;
    private JTable tableCustomers;


    public ViewCustomerAccount(BAPERS system){
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


    }
    public ArrayList<CustomerAccount>customerAccounts() {
        ArrayList<CustomerAccount> customersAccounts = new ArrayList<>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            CustomerAccount customerAccount;

            while (rs.next()) {
                customerAccount = new CustomerAccount(
                        rs.getString("Name"),rs.getString("Contact_Name"),
                        rs.getString("Email"),rs.getInt("accountNo"),rs.getString("address"),rs.getInt("phone"),
                        rs.getString("discountPlan"),rs.getBoolean("valuedCustomer"));
                customersAccounts.add(customerAccount);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


        return customersAccounts;
    }

    public void show_customerAccount(){
        ArrayList<CustomerAccount>list = customerAccounts();
        DefaultTableModel model = (DefaultTableModel) tableCustomers.getModel();
        Object[] row = new Object[7];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getContactName();
            row[2]=list.get(i).getEmail();
            row[3]=list.get(i).getAccountNo();
            row[4]=list.get(i).getAddress();
            row[5]=list.get(i).getPhone();
            row[6]=list.get(i).getDiscountPlan();
            row[7]=list.get(i).getValuedCustomer();
            model.addRow(row);

        }
    }

}
