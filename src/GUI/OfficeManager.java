package GUI;

import javax.swing.*;

public class OfficeManager extends Screen {
    private JPanel panelOfficeManager;
    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JPanel panelMiddle;
    private JButton btnIdentifyCustomer;
    private JButton btnBackupDatabase;
    private JButton btnCreateCustomer;
    private JButton btnRestoreDatabase;
    private JButton btnCreateUser;
    private JButton btnAccount;
    private JButton btnReport;
    private JButton btnBack;
    private JPanel panelBottom;

    public OfficeManager(){
        this.setContentPane(this.panelOfficeManager);
        this.pack();
    }
}
