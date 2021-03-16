package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.BAPERS;

public class LogIn extends Screen {
    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonLogIn;
    private JButton buttonForgotPassword;
    private JPanel panelLogIn;

    public LogIn(BAPERS system){
        super(system);
        this.setContentPane(this.panelLogIn);
        this.pack();

        buttonLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogIn(textField1.getText(), passwordField1.getText());
            }
        });
    }
}
