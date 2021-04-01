package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTask extends Screen {
    private JPanel panelTop;
    private JLabel labelAddTask;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelUpdateTask;
    private JLabel labelTaskId;
    private JTextField txtTaskID;
    private JLabel labelStartTime;
    private JTextField txtStartTime;
    private JButton updateStartTime;
    private JPanel panelThree;
    private JLabel labelLocation;
    private JTextField txtLocation;
    private JButton updateLocation;
    private JPanel panelFive;
    private JLabel labelDuration;
    private JTextField txtDuration;
    private JButton updateDuration;
    private JPanel panelSix;
    private JLabel labelShift;
    private JTextField txtShift;
    private JButton updateShift;
    private JLabel labelStatus;
    private JTextField txtStatus;
    private JButton updateStatus;
    private JPanel panelEight;
    private JLabel labelCompletedBy;
    private JTextField txtCompleted;
    private JButton updateCompleted;
    private JPanel panelTen;
    private JLabel labelStaffId;
    private JTextField txtStaffID;
    private JButton updateStaffID;
    private JLabel labelTimeTaken;
    private JTextField txtTimeTaken;
    private JButton updateTimeTaken;
    private JPanel panleEleven;
    private JButton btnBack;

    public UpdateTask(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUpdateTask);
        this.pack();

        updateStartTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtStartTime.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateTaskStartTime(txtStartTime.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtLocation.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateLocation(txtLocation.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateDuration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDuration.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateDuration(txtDuration.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateShift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtShift.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateTaskShift(txtShift.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtStatus.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateTaskStatus(txtStatus.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateCompleted.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCompleted.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateCompletedBy(txtCompleted.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateStaffID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtStaffID.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateTaskStaffId(txtStaffID.getText(), txtTaskID.getText());
                    }
                }
            }
        });
        updateTimeTaken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTimeTaken.getText().length() > 0) {
                    if (txtTaskID.getText().length() > 0) {
                        system.getController().updateTaskTimeTaken(txtTimeTaken.getText(), txtTaskID.getText());
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
