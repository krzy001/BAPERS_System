package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJob extends Screen{
    private JPanel panelTop;
    private JLabel labelAddJob;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelTwo;
    private JLabel labelStartTime;
    private JTextField txtStartTime;
    private JButton updateStartTime;
    private JPanel panelFive;
    private JLabel labelJobStatus;
    private JButton updateJobStatus;
    private JTextField txtJobStatus;
    private JPanel panelSix;
    private JLabel labelDate;
    private JTextField txtDate;
    private JButton updateDate;
    private JPanel panelSeven;
    private JButton btnBack;
    private JTextField txtJobID;
    private JPanel panelUpdateJob;

    public UpdateJob(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateJob);
        this.pack();


        updateStartTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtStartTime.getText().length() > 0) {
                    if (txtJobID.getText().length() > 0) {
                        system.getController().updateJobStartTime(txtStartTime.getText(), txtJobID.getText());
                    }
                }
            }
        });
        updateJobStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtJobStatus.getText().length() > 0) {
                    if (txtJobID.getText().length() > 0) {
                        system.getController().updateJobStatus(txtJobStatus.getText(), txtJobID.getText());
                    }
                }
            }
        });
        updateDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDate.getText().length() > 0) {
                    if (txtJobID.getText().length() > 0) {
                        system.getController().updateDate(txtDate.getText(), txtJobID.getText());
                    }
                }
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
    }
}
