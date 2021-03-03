package GUI;

import javax.swing.*;

public class IdentifyCustomer extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JButton btnSearch;
    private JPanel panelBottom;
    private JPanel panelIdentifyCustomer;
    private JButton btnBack;

    public IdentifyCustomer() {
        this.setContentPane(this.panelIdentifyCustomer);
        this.pack();
    }
}
