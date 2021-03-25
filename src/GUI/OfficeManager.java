package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OfficeManager extends Screen {
    private JPanel panelOfficeManager;
    private JPanel panelTop;
    private JButton btnReport;
    private JButton btnBack;
    private JPanel panelBottom;
    private JButton btnLogOut;
    private JButton addJobButton;
    private JLabel labelLogo;
    private JButton searchCustomerButton;
    private JButton createCustomerButton;
    private JButton searchUserButton;
    private JButton createUserButton;
    private JButton addTaskButton;
    private JButton searchJobButton;
    private JButton searchTaskButton;
    private JButton backupButton;
    private JButton restoreButton;
    private JLabel labelOfficeManager;

    public OfficeManager(BAPERS system){
        super(system);
        this.setContentPane(this.panelOfficeManager);
        this.pack();
        float logo = 80;
        float size = 30;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelOfficeManager.setFont(labelLogo.getFont().deriveFont(size));

        btnReport.setPreferredSize(new Dimension(250,50));
        btnBack.setPreferredSize(new Dimension(250,50));
        btnLogOut.setPreferredSize(new Dimension(250,50));
        addJobButton.setPreferredSize(new Dimension(250,50));
        addTaskButton.setPreferredSize(new Dimension(250,50));
        searchCustomerButton.setPreferredSize(new Dimension(250,50));
        createCustomerButton.setPreferredSize(new Dimension(250,50));
        searchUserButton.setPreferredSize(new Dimension(250,50));
        createUserButton.setPreferredSize(new Dimension(250,50));
        addTaskButton.setPreferredSize(new Dimension(250,50));
        searchJobButton.setPreferredSize(new Dimension(250,50));
        searchTaskButton.setPreferredSize(new Dimension(250,50));
        backupButton.setPreferredSize(new Dimension(250,50));
        restoreButton.setPreferredSize(new Dimension(250,50));


        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        searchCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyCustomer);
            }
        });
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateCustomerAccount);
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateNewUser);
            }
        });
        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Backup);
            }
        });
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {system.nextScreen(system.Restore);}
        });
        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyUser);
            }
        });
        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Reports);
            }
        });
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
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
        searchTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTask);
            }
        });
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
    }
}
