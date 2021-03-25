package GUI;

import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIndividualPerformanceReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel scrollPane;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelIndividualPerformanceReport;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JTable table1;
    private JButton printButton;

    public ViewIndividualPerformanceReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualPerformanceReport);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        printButton.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model = system.generateIndividualPerformanceReport();

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
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().IndividualPerformanceReport();
            }
        });
    }
}
