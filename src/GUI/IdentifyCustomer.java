package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdentifyCustomer extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JButton btnSearch;
    private JPanel panelBottom;
    private JPanel panelIdentifyCustomer;
    private JButton btnBack;
    private JButton btnLogout;

    public IdentifyCustomer(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIdentifyCustomer);
        this.pack();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
    }
}
