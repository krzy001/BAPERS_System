package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserInfo extends Screen {
    private JPanel panelTop;
    private JButton btnLogout;
    private JPanel panelThree;
    private JTextField textField1;
    private JPanel panelFour;
    private JTextField textField2;
    private JPanel panelFive;
    private JTextField textField3;
    private JPanel panelSix;
    private JTextField textField4;
    private JPanel panelSeven;
    private JTextField textField5;
    private JPanel panelEight;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnUpdate;
    private JPanel panelUpdateUserInfo;
    private JPanel panelMiddle;

    public UpdateUserInfo(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateUserInfo);
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

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().updateUserInfo(
                        textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                        textField5.getText(), textField6.getText(), textField7.getText());
            }
        });
    }
}
