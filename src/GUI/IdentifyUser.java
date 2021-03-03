package GUI;

import javax.swing.*;

public class IdentifyUser extends Screen{
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JPanel panelIdentifyUser;
    private JButton btnSearch;
    private JButton btnBack;

    public IdentifyUser() {
        this.setContentPane(this.panelIdentifyUser);
        this.pack();
    }
}
