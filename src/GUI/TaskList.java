package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Control.BAPERS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskList extends Screen{
    private JPanel panelTaskList;
    private JPanel panelTop;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddTask;
    private JLabel labelLogo;
    private JButton removeTaskButton;
    private JButton changeTaskButton;
    private JTable taskTable;

    public TaskList(BAPERS system){
        super(system);
        this.setContentPane(this.panelTaskList);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        DefaultTableModel model = new DefaultTableModel(new String[]{
                "Task ID", "Task Description", "Location", "Price",
                "Duration", "Shift", "Date", "Status",
                "Completed By","Job ID", "Staff ID"}, 0);

        try {
            String sql = "SELECT * FROM task";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                String taskID = rs.getString(1);
                String taskDescription = rs.getString(2);
                String location = rs.getString(3);
                String price = rs.getString(4);
                String duration = rs.getString(5);
                String shift = rs.getString(6);
                String date = rs.getString(7);
                String status = rs.getString(8);
                String completedBy = rs.getString(9);
                String jobID = rs.getString(10);
                String staffID = rs.getString(11);
                model.addRow(new Object[]{
                        taskID, taskDescription, location, price,
                        duration, shift, date, status,
                        completedBy,jobID,staffID});
            }

            taskTable.setModel(model);

        }
        catch (Exception e1){
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

        btnAddTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        changeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
