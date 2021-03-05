package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewUser extends Screen{
    private JPanel panelTop;
    private JPanel panelTwo;
    private JButton btnCreate;
    private JPanel panelCreateNewUser;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPanel panelEight;
    private JButton btnBack;
    private JPanel panelBottom;
    private JButton btnLogout;

    public CreateNewUser(BAPERS system) {
        super(system);
        this.setContentPane(this.panelCreateNewUser);
        this.pack();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("LI");
            }
        });
    }
}
