package GUI;

import javax.swing.*;

public class ShiftManager extends Screen{
    private JPanel panelShiftManager;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JButton btnReport;
    private JButton backButton;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelTop;
    private JPanel panelFive;

    public ShiftManager(){
        this.setContentPane(this.panelShiftManager);
        this.pack();
    }
}
