package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShiftManager extends Screen{
    private JPanel panelShiftManager;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JButton btnSearchTask;
    private JButton backButton;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelTop;
    private JPanel panelFive;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton addJobButton;
    private JButton searchJobButton;
    private JButton addTaskButton;
    private JButton taskListButton;
    private JButton jobListButton;
    private JButton reportButton;

    public ShiftManager(BAPERS system){
        super(system);
        this.setContentPane(this.panelShiftManager);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnCreateCustomer.setPreferredSize(new Dimension(150,30));
        btnIdentifyCustomer.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        backButton.setPreferredSize(new Dimension(150,30));
        btnSearchTask.setPreferredSize(new Dimension(150,30));
        addJobButton.setPreferredSize(new Dimension(150,30));
        addTaskButton.setPreferredSize(new Dimension(150,30));
        taskListButton.setPreferredSize(new Dimension(150,30));
        jobListButton.setPreferredSize(new Dimension(150,30));
        reportButton.setPreferredSize(new Dimension(150,30));

        backButton.addActionListener(new ActionListener() {
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
        btnCreateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateCustomerAccount);
            }
        });
        btnIdentifyCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyCustomer);
            }
        });
        addJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
        searchJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchJob);
            }
        });
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
        btnSearchTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTask);
            }
        });
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobList);
            }
        });
    }
}
