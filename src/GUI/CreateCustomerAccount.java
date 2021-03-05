package GUI;

import Control.BAPERS;

import javax.swing.*;

public class CreateCustomerAccount extends Screen{
    private JPanel panelTop;
    private JButton btnCreate;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPanel panelCreateCustomer;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JPanel panelEight;
    private JPanel panelBottom;
    private JButton btnBack;

    public CreateCustomerAccount(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateCustomer);
        this.pack();
    }
}
