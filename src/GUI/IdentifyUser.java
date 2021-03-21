package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdentifyUser extends Screen{
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JPanel panelIdentifyUser;
    private JButton btnSearch;
    private JButton btnBack;
    private JButton btnLogout;
    private JLabel labelLogo;
    private boolean userFound;

    public IdentifyUser(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIdentifyUser);
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
                userFound = system.getController().identifyUserAccount(textField1.getText());

                if(userFound){
                    system.nextScreen(system.ViewUserAccount,textField1.getText());
                }
            }
        });
    }
}
