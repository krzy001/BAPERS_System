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
    private JLabel labelIndividualReport;
    private JLabel labelIndividualPerformanceReport;
    private JLabel labelSummaryReport;

    public Reports(BAPERS system){
        super(system);
        this.setContentPane(this.panelReports);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelSummaryReport.setFont(labelLogo.getFont().deriveFont(size));
        labelIndividualPerformanceReport.setFont(labelLogo.getFont().deriveFont(size));
        labelIndividualReport.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(250,50));
        btnLogout.setPreferredSize(new Dimension(250,50));
        btnView1.setPreferredSize(new Dimension(250,50));
        btnView2.setPreferredSize(new Dimension(250,50));
        btnView3.setPreferredSize(new Dimension(250,50));

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
