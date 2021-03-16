package GUI;

import Control.BAPERS;
import com.mysql.cj.jdbc.JdbcConnection;
import database.dbConnection;

import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddJob extends Screen {
    private JPanel panelAddJob;
    private JPanel panelTop;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JButton btnAddJob;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton btnBack;
    private JButton btnLogout;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JPanel panelEight;
    private JPanel panelNine;
    private JPanel panelTen;

    public AddJob(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddJob);
        this.pack();

        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost/risinggen";
        String user="root";
        String pass="";

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });

        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url,user,pass);
                    String sql = "INSERT INTO jobs (Start_Time,Priority,Special_Instructions,Job_Status,Date,Deadline,Price,CustomerAccount_No) values (?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1,textField1.getText());
                    pst.setString(2,textField2.getText());
                    pst.setString(3,textField3.getText());
                    pst.setString(4,textField4.getText());
                    pst.setString(5,textField5.getText());
                    pst.setString(6,textField6.getText());
                    pst.setString(7,textField7.getText());
                    pst.setString(8,textField8.getText());

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
