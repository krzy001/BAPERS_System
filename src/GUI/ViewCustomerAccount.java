package GUI;

import Control.BAPERS;

import javax.swing.*;

public class ViewCustomerAccount extends Screen{
    private JPanel panelTop;
    private JPanel panelViewCustomer;
    private JButton btnAddPayment;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton btnUpdate;
    private JPanel panelBottom;
    private JPanel panelMiddle;

    public ViewCustomerAccount(BAPERS system){
        super(system);
        this.setContentPane(this.panelViewCustomer);
        this.pack();
    }
}
