package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
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
    private JLabel labelJobId;

    public UpdateJob(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateJob);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelAddJob.setFont(labelLogo.getFont().deriveFont(size));
        labelStartTime.setFont(labelLogo.getFont().deriveFont(size));
        labelJobStatus.setFont(labelLogo.getFont().deriveFont(size));
        labelDate.setFont(labelLogo.getFont().deriveFont(size));
        labelJobId.setFont(labelLogo.getFont().deriveFont(size));

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        updateStartTime.setPreferredSize(new Dimension(150,30));
        updateJobStatus.setPreferredSize(new Dimension(150,30));
        updateDate.setPreferredSize(new Dimension(150,30));


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
