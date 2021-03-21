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

public class JobsList extends Screen{
    private JPanel panelTop;
    private JButton btnBack;
    private JButton btnAddJob;
    private JPanel panelJobsList;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnLogout;
    private JLabel jLabelStartTime;
    private JLabel jLabelPriority;
    private JLabel jLabelSpecialInstructions;
    private JLabel jLabelJobStatus;
    private JLabel jLabelDate;
    private JLabel jLabelDeadline;
    private JLabel jLabelPrice;
    private JLabel jLabelCustomerID;
    private JLabel labelLogo;
    private JButton removeJobButton;
    private JButton changeJobButton;

    public JobsList(BAPERS system){
        super(system);
        this.setContentPane(this.panelJobsList);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
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
        removeJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        changeJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
