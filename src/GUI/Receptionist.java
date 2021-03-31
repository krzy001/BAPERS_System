package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receptionist extends Screen{
    private JPanel panelReceptionist;
    private JPanel panelTop;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JPanel panelTwo;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton backButton;
    private JButton addJobButton;
    private JButton searchJobButton;
    private JButton addTaskButton;
    private JButton searchTaskButton;
    private JButton jobListButton;
    private JButton taskListButton;
    private JButton searchPaymentButton;
    private JButton paymentListButton;

    public Receptionist(BAPERS system){
        super(system);
        this.setContentPane(this.panelReceptionist);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        backButton.setPreferredSize(new Dimension(250,50));
        addJobButton.setPreferredSize(new Dimension(250,50));
        btnLogout.setPreferredSize(new Dimension(250,50));
        searchJobButton.setPreferredSize(new Dimension(250,50));
        searchTaskButton.setPreferredSize(new Dimension(250,50));
        addTaskButton.setPreferredSize(new Dimension(250,50));
        jobListButton.setPreferredSize(new Dimension(250,50));
        taskListButton.setPreferredSize(new Dimension(250,50));
        btnCreateCustomer.setPreferredSize(new Dimension(250,50));
        btnIdentifyCustomer.setPreferredSize(new Dimension(250,50));

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
        searchTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTask);
            }
        });
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobList);
            }
        });
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        searchPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchPayment);
            }
        });
        paymentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.PaymentList);
            }
        });
    }
}
