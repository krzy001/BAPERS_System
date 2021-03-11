package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndividualJobReport extends Screen {
    private JPanel panelTop;
    private JButton btnBack;
    private JTextArea IndividualJobReport;
    private JPanel panelMiddle;
    private JPanel panelIndividualJobReport;
    private JPanel panelBottom;
    private JPanel scrollPane;
    private JButton btnLogout;

    public IndividualJobReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualJobReport);
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
