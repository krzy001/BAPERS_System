package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Technician extends Screen {
    private JPanel panelTechnician;
    private JPanel panelTop;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton jobListButton;
    private JButton taskListButton;
    private JButton searchJobButton;
    private JButton searchTaskButton;
    private JButton updateJobButton;
    private JButton updateTaskButton;
    private JButton jobEnquiryButton;

    public Technician(BAPERS system){
        super(system);
        this.setContentPane(this.panelTechnician);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        jobListButton.setPreferredSize(new Dimension(150,30));
        taskListButton.setPreferredSize(new Dimension(150,30));
        searchJobButton.setPreferredSize(new Dimension(150,30));
        searchTaskButton.setPreferredSize(new Dimension(150,30));

        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobListTech);
            }
        });
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskListTech);
            }
        });
        searchJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchJobTech);
            }
        });
        searchTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTaskTech);
            }
        });
        updateJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.UpdateJob);
            }
        });
        updateTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.UpdateTask);
            }
        });
        jobEnquiryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobEnquiry);
            }
        });
    }
}
