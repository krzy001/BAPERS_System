package GUI;

import javax.swing.*;

public class ViewUserAccount extends Screen {
    private JPanel panelTop;
    private JPanel panelVewUser;
    private JButton btnBack;
    private JButton btnUpdate;
    private JPanel panelBottom;
    private JPanel panelMiddle;

    public ViewUserAccount(){
        this.setContentPane(this.panelVewUser);
        this.pack();
    }
}
