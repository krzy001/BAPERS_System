package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receptionist extends Screen{
    private JPanel panelReceptionist;
    private JPanel panelTop;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JButton btnLogout;
    private JLabel labelLogo;

    public Receptionist(BAPERS system){
        super(system);
        this.setContentPane(this.panelReceptionist);
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
        btnCreateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateCustomerAccount);
            }
        });
        btnIdentifyCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyCustomer);
            }
        });
    }
}
