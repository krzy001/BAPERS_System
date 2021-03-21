package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndividualPerformanceReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextArea IndividualPerformanceReport;
    private JPanel scrollPane;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelIndividualPerformanceReport;
    private JButton btnLogout;
    private JLabel labelLogo;

    public IndividualPerformanceReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualPerformanceReport);
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
