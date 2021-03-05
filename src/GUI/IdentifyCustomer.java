package GUI;

import Control.BAPERS;

import javax.swing.*;

public class IdentifyCustomer extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JButton btnSearch;
    private JPanel panelBottom;
    private JPanel panelIdentifyCustomer;
    private JButton btnBack;

    public IdentifyCustomer(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIdentifyCustomer);
        this.pack();
    }
}
