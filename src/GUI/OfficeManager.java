package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton btnLogOut;

    public OfficeManager(BAPERS system){
        super(system);
        this.setContentPane(this.panelOfficeManager);
        this.pack();
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        btnIdentifyCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("IC");
            }
        });
    }
}
