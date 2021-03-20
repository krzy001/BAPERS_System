package GUI;

import javax.swing.*;
import Control.BAPERS;

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
    private JLabel jLabelStartTime;
    private JLabel jLabelPriority;
    private JLabel jLabelSpecialInstructions;
    private JLabel jLabelJobStatus;
    private JLabel jLabelDate;
    private JLabel jLabelDeadline;
    private JLabel jLabelPrice;
    private JLabel jLabelCustomerID;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddTask;

    public TaskList(BAPERS system, String jobID){
        super(system);
        this.setContentPane(this.panelTaskList);
        this.pack();


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
    }
}
