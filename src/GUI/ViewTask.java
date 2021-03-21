package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTask extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JLabel jLabelName;
    private JLabel jLabelContactName;
    private JLabel jLabelAddress;
    private JLabel jLabelPhone;
    private JLabel jLabelEmail;
    private JLabel jLabelDiscountPlan;
    private JLabel jLabelValued;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton taskListButton;
    private JButton changeButton;
    private JButton removeButton;
    private JPanel panelViewTask;
    private JButton completeButton;

    public ViewTask(BAPERS system, String taskId) {
        super(system);
        this.setContentPane(this.panelViewTask);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

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
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });

    }
}
