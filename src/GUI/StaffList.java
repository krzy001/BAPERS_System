package GUI;

import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffList extends Screen {

    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JTable taskTable;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddStaff;
    private JButton btnSearchStaff;
    private JPanel panelStaffList;
    private JCheckBox checkBoxOffice;
    private JCheckBox checkBoxShift;
    private JCheckBox checkBoxResp;
    private JCheckBox checkBoxTech;

    public StaffList(BAPERS system) {
        super(system);
        this.setContentPane(this.panelStaffList);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnAddStaff.setPreferredSize(new Dimension(150,30));
        btnSearchStaff.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model1 = new DefaultTableModel(new String[]{
                "Staff ID", "Name", "Username","Role", "Email",
                "Department"}, 0);

        DefaultTableModel model2 = new DefaultTableModel(new String[]{
                "Staff ID", "Name", "Username","Role", "Email",
                "Department"}, 0);

        DefaultTableModel model3 = new DefaultTableModel(new String[]{
                "Staff ID", "Name", "Username","Role", "Email",
                "Department"}, 0);

        DefaultTableModel model4 = new DefaultTableModel(new String[]{
                "Staff ID", "Name", "Username","Role", "Email",
                "Department"}, 0);

        DefaultTableModel model5 = new DefaultTableModel(new String[]{
                "Staff ID", "Name", "Username","Role", "Email",
                "Department"}, 0);

        try {
            String sql = "SELECT * FROM staff";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String staffID = rs.getString(1);
                String name = rs.getString(2);
                String username = rs.getString(3);
                String role = rs.getString(5);
                String email = rs.getString(6);
                String department = rs.getString(7);
                model1.addRow(new Object[]{
                        staffID, name, username, role, email, department});
            }
            taskTable.setModel(model1);
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql = "SELECT * FROM staff WHERE Job_Role = 'Office Manager'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String staffID = rs.getString(1);
                String name = rs.getString(2);
                String username = rs.getString(3);
                String role = rs.getString(5);
                String email = rs.getString(6);
                String department = rs.getString(7);
                model2.addRow(new Object[]{
                        staffID, name, username, role, email, department});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql = "SELECT * FROM staff WHERE Job_Role = 'Shift Manager'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String staffID = rs.getString(1);
                String name = rs.getString(2);
                String username = rs.getString(3);
                String role = rs.getString(5);
                String email = rs.getString(6);
                String department = rs.getString(7);
                model3.addRow(new Object[]{
                        staffID, name, username, role, email, department});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql = "SELECT * FROM staff WHERE Job_Role = 'Receptionist'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String staffID = rs.getString(1);
                String name = rs.getString(2);
                String username = rs.getString(3);
                String role = rs.getString(5);
                String email = rs.getString(6);
                String department = rs.getString(7);
                model4.addRow(new Object[]{
                        staffID, name, username, role, email, department});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        try {
            String sql = "SELECT * FROM staff WHERE Job_Role = 'Technician'";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String staffID = rs.getString(1);
                String name = rs.getString(2);
                String username = rs.getString(3);
                String role = rs.getString(5);
                String email = rs.getString(6);
                String department = rs.getString(7);
                model5.addRow(new Object[]{
                        staffID, name, username, role, email, department});
            }
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        btnSearchStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyUser);
            }
        });
        btnAddStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateNewUser);
            }
        });
        checkBoxOffice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxOffice.setFocusable(false);
                if(checkBoxOffice.isSelected()) {
                    taskTable.setModel(model2);
                    checkBoxShift.setSelected(false);
                    checkBoxResp.setSelected(false);
                    checkBoxTech.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        checkBoxShift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxShift.setFocusable(false);
                if(checkBoxShift.isSelected()) {
                    taskTable.setModel(model3);
                    checkBoxOffice.setSelected(false);
                    checkBoxResp.setSelected(false);
                    checkBoxTech.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        checkBoxResp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxResp.setFocusable(false);
                if(checkBoxResp.isSelected()) {
                    taskTable.setModel(model4);
                    checkBoxOffice.setSelected(false);
                    checkBoxShift.setSelected(false);
                    checkBoxTech.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
        checkBoxTech.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxTech.setFocusable(false);
                if(checkBoxTech.isSelected()) {
                    taskTable.setModel(model5);
                    checkBoxOffice.setSelected(false);
                    checkBoxShift.setSelected(false);
                    checkBoxResp.setSelected(false);
                }
                else{
                    taskTable.setModel(model1);
                }
            }
        });
    }
}