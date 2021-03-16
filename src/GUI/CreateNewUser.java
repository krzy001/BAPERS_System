package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateNewUser extends Screen{
    private JPanel panelTop;
    private JPanel panelTwo;
    private JButton btnCreate;
    private JPanel panelCreateNewUser;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPanel panelEight;
    private JButton btnBack;
    private JPanel panelBottom;
    private JButton btnLogout;

    public CreateNewUser(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateNewUser);
        this.pack();

        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost/risinggen";
        String user="root";
        String pass="";

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
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url,user,pass);
                    String sql = "INSERT INTO staff (Name,Username,Password,Job_Role,EMail,Department) values (?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1,textField1.getText());
                    pst.setString(2,textField2.getText());
                    pst.setString(3,textField3.getText());
                    pst.setString(4,textField4.getText());
                    pst.setString(5,textField5.getText());
                    pst.setString(6,textField6.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Saved");
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null,e1);
                }
            }
        });
    }
}
