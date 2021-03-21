package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.BAPERS;

public class LogIn extends Screen {
    private JPanel panelTop;
    private JPanel panelLeft;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonLogIn;
    private JPanel panelLogIn;
    private JLabel labelLogo;
    private JLabel labelUsername;
    private JLabel labelPassword;

    public LogIn(BAPERS system){
        super(system);
        this.setContentPane(this.panelLogIn);
        this.pack();
        float logo = 80;
        float username = 20;
        float password = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelUsername.setFont(labelUsername.getFont().deriveFont(username));
        labelPassword.setFont(labelPassword.getFont().deriveFont(password));
        buttonLogIn.setPreferredSize(new Dimension(250,50));
        /*
        buttonLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.OfficeManager);
            }
        });
         */

        buttonLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogIn(textField1.getText(), passwordField1.getText());
            }
        });
    }
}
