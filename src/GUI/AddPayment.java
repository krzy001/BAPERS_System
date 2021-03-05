package GUI;

import Control.BAPERS;

import javax.swing.*;

public class AddPayment extends Screen {
    private JPanel panelTop;
    private JButton btnAddPayment;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelAddPayment;
    private JButton btnBack;

    public AddPayment(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddPayment);
        this.pack();
    }
}
