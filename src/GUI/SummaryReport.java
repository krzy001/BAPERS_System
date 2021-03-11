package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextArea SummaryReport;
    private JPanel scrollPane;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelSummaryReport;
    private JButton btnLogout;

    public SummaryReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelSummaryReport);
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
    }

}
