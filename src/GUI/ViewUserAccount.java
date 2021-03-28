package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewUserAccount extends Screen {
    private JPanel panelTop;
    private JPanel panelVewUser;
    private JButton btnBack;
    private JButton btnUpdate;
    private JPanel panelBottom;
    private JPanel panelMiddle;
    private JButton btnLogout;
    private JLabel jLabelName;
    private JLabel jLabelUsername;
    private JLabel jLabelRole;
    private JLabel jLabelDepartment;
    private JLabel labelLogo;
    private JLabel jLabelEmail;

    public ViewUserAccount(BAPERS system){
        super(system);
        this.setContentPane(this.panelVewUser);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnUpdate.setPreferredSize(new Dimension(150,30));


        try{
            String sql = "SELECT * FROM staff WHERE Staff_ID = '" + system.getID() + "' ";

            Connection con = DriverManager.getConnection(url,user,pass);

            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()){

                String name = rs.getString(2);
                String username = rs.getString(3);
                String role = rs.getString(5);
                String email = rs.getString(6);
                String department = rs.getString(7);

                jLabelName.setText(name);
                jLabelUsername.setText(username);
                jLabelRole.setText(role);
                jLabelEmail.setText(email);
                jLabelDepartment.setText(department);

            }
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

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
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.UpdateUserInfo);
            }
        });
    }
}
