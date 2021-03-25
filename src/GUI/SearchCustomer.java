package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchCustomer extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JButton btnSearch;
    private JPanel panelBottom;
    private JPanel panelIdentifyCustomer;
    private JButton btnBack;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JLabel labelSearchAccountNo;
    private boolean customerFound;

    public SearchCustomer(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIdentifyCustomer);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelSearchAccountNo.setFont(labelLogo.getFont().deriveFont(size));

        btnSearch.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));

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
                    system.setID(textField1.getText());
                    system.nextScreen(system.ViewCustomerAccount);
                }
            }
        });
    }
}
