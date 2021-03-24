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
    private JComboBox comboBox1;
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost/risinggen";
    String user="root";
    String pass="";

    public LogIn(BAPERS system){
        super(system);
        this.setContentPane(this.panelLogIn);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelUsername.setFont(labelUsername.getFont().deriveFont(size));
        labelPassword.setFont(labelPassword.getFont().deriveFont(size));
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
                /*system.LogIn(textField1.getText(), passwordField1.getText(),String.valueOf(comboBox1.getSelectedItem()));*/
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);
                    String sql = "SELECT * FROM staff WHERE Username=? AND Password=? AND Job_Role=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, textField1.getText());
                    pst.setString(2, passwordField1.getText());
                    pst.setString(3, String.valueOf(comboBox1.getSelectedItem()));

                    ResultSet rs1 = pst.executeQuery();
                    if (rs1.next()) {
                        JOptionPane.showMessageDialog(null, "Username & Password Correct, You are logged in as " + rs1.getString("Job_Role"));
                        if(comboBox1.getSelectedIndex()==0){
                            system.nextScreen(system.OfficeManager);
                        }
                        else if(comboBox1.getSelectedIndex()==1){
                            system.nextScreen(system.ShiftManager);
                        }
                        else if(comboBox1.getSelectedIndex()==2){
                            system.nextScreen(system.Technician);
                        }
                        else if(comboBox1.getSelectedIndex()==3){
                            system.nextScreen(system.Receptionist);
                        }

                        String role = rs1.getString("Job_Role");

                        system.setRoleLoggedIn(role);

                        system.setRoleLoggedIn(system.OfficeManager);
                        //system.setRoleLoggedIn(system.ShiftManager);
                        //system.setRoleLoggedIn(system.Receptionist);
                        //system.setRoleLoggedIn(system.Technician);

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
