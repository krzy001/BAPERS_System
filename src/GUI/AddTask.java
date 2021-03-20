package GUI;

import javax.swing.*;
import Control.BAPERS;

import javax.swing.*;
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

    public AddTask(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddTask);
        this.pack();

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
                        textField9.getText());
            }
        });
    }
}
