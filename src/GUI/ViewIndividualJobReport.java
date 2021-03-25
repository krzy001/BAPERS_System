package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIndividualJobReport extends Screen {
    private JPanel panelTop;
    private JButton btnBack;
    private JPanel panelMiddle;
    private JPanel panelIndividualJobReport;
    private JPanel panelBottom;
    private JPanel scrollPane;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton printButton;
    private JTable table1;

    public ViewIndividualJobReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualJobReport);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        //system.generateIndividualJobReport();


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
