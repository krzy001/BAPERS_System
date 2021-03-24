package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reports extends Screen {
    private JPanel panelReports;
    private JPanel panelTop;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JButton btnView1;
    private JButton btnView2;
    private JButton btnView3;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnLogout;
    private JLabel labelLogo;

    public Reports(BAPERS system){
        super(system);
        this.setContentPane(this.panelReports);
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
    }
}
