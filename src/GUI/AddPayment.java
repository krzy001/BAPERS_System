package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddPayment extends Screen {
    private JPanel panelTop;
    private JButton btnAddPayment;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelAddPayment;
    private JButton btnBack;
    private JButton btnLogout;
    private JPanel panelSeven;
    private JTextField textField3;

    public AddPayment(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddPayment);
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
        btnAddPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url,user,pass);
                    String sql = "INSERT INTO payment () values ()";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1,textField1.getText());
                    pst.setString(2,textField2.getText());
                    pst.setString(3,textField3.getText());
                    pst.setString(4,textField4.getText());
                    pst.setString(5,textField5.getText());

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
