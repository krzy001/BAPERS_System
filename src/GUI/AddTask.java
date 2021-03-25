package GUI;

import javax.swing.*;
import Control.BAPERS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTask extends Screen {
    private JPanel panelTop;
    private JButton btnLogout;
    private JPanel panelAddTask;
    private JPanel panelTwo;
    private JTextField textField1;
    private JPanel panelThree;
    private JTextField textField2;
    private JPanel panelFour;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JPanel panelEight;
    private JPanel panelTen;
    private JButton btnBack;
    private JButton btnAddJob;
    private JPanel panleEleven;
    private JPanel panelNine;
    private JLabel labelLogo;
    private JTextField textField10;
    private JTextField textField11;
    private JButton updateButton;
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JButton updateButton4;
    private JButton updateButton5;
    private JButton updateButton6;
    private JButton updateButton7;
    private JButton updateButton8;
    private JButton updateButton9;
    private JButton removeButton;
    private JTextField textField12;
    private JLabel labelStartTime;
    private JButton updateButton10;

    public AddTask(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddTask);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnBack.addActionListener(new ActionListener() {
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

        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().addTask(
                        textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                        textField5.getText(), textField6.getText(), textField7.getText(), textField8.getText(),
                        textField9.getText(),textField10.getText(),textField11.getText());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateDescription(textField1.getText(),textField11.getText());
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateLocation(textField2.getText(),textField11.getText());
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskPrice(textField3.getText(),textField11.getText());
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskShift(textField5.getText(),textField11.getText());
            }
        });updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskDate(textField6.getText(),textField11.getText());
            }
        });
        updateButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskStatus(textField10.getText(),textField11.getText());
            }
        });updateButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateCompletedBy(textField7.getText(),textField11.getText());
            }
        });
        updateButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskJobsNo(textField8.getText(),textField11.getText());
            }
        });
        updateButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskStaffId(textField9.getText(),textField11.getText());
            }
        });
        updateButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateDuration(textField4.getText(),textField11.getText());
            }
        });

        updateButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateTaskStartTime(textField12.getText(),textField11.getText());
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().removeTask(textField11.getText());
            }
        });
    }
}
