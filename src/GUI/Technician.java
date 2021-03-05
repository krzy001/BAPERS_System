package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Technician extends Screen {
    private JPanel panelTechnician;
    private JPanel panelTop;
    private JButton btnJobEnquiry;
    private JButton btnResponse;
    private JButton btnBack;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelBottom;
    private JButton btnLogout;

    public Technician(BAPERS system){
        super(system);
        this.setContentPane(this.panelTechnician);
        this.pack();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("LI");
            }
        });
        btnJobEnquiry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("JE");
            }
        });
        btnResponse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("JE");
            }
        });
    }
}
