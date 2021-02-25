package GUI;

import javax.swing.*;

public class LogIn extends Screen {
    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonLogIn;
    private JButton buttonForgotPassword;
    private JPanel panelLogIn;

    public LogIn(){
        this.setContentPane(this.panelLogIn);
        this.pack();
    }

    /*
    @Override
    public void show(){
        LogIn screen = new LogIn();
        screen.setVisible(true);
    }
    */
}
