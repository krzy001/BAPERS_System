package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Control.BAPERS;
import Control.Control;

public class LogIn extends Screen {
    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonLogIn;
    private JButton buttonForgotPassword;
    private JPanel panelLogIn;
    ResultSet rs=null;

    public LogIn(BAPERS system){
        super(system);
        this.setContentPane(this.panelLogIn);
        this.pack();

        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost/risinggen";
        String user="root";
        String pass="";

        buttonLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //If details in database correct
                system.LogIn();
            }
        });
        buttonLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);
                    String sql = "SELECT * FROM staff WHERE Username=? AND Password =?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, textField1.getText());
                    pst.setString(2, passwordField1.getText());

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Username & Password Correct");
                        OfficeManager om = new OfficeManager(system);
                        om.setVisible(true);
                        setVisible(false);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Username & Password Incorrect");
                    }
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null,e1);
                }
            }
        });
    }
}
