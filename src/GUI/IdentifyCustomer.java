package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
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
    private JLabel labelLogo;
    private boolean customerFound;

    public IdentifyCustomer(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIdentifyCustomer);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerFound = system.getController().identifyCustomerAccount(textField1.getText());

                if(customerFound){
                    system.nextScreen(system.ViewCustomerAccount,textField1.getText());
                }
            }
        });
    }
}
