package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddJob extends Screen {
    private JPanel panelAddJob;
    private JPanel panelTop;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JPanel panelSix;
    private JPanel panelSeven;
    private JButton btnAddJob;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton btnBack;
    private JButton btnLogout;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JPanel panelEight;
    private JPanel panelNine;
    private JPanel panelTen;
    private JLabel labelLogo;
    private JButton updateButton;
    private JButton updateButton3;
    private JButton updateButton4;
    private JTextField textField9;
    private JButton removeButton;
    private JLabel labelJobNo;
    private JLabel labelStartTime;
    private JLabel labelPriority;
    private JLabel labelSpecialInstruction;
    private JLabel labelJobStatus;
    private JLabel labelDate;
    private JLabel labelDeadline;
    private JLabel labelPrice;
    private JLabel labelCustomerAccountNo;
    private JLabel labelAddJob;

    //Class for the interface adding a job
    public AddJob(BAPERS system){
        super(system);
        this.setContentPane(this.panelAddJob);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelJobNo.setFont(labelJobNo.getFont().deriveFont(size));
        labelStartTime.setFont(labelStartTime.getFont().deriveFont(size));
        labelPriority.setFont(labelPriority.getFont().deriveFont(size));
        labelSpecialInstruction.setFont(labelSpecialInstruction.getFont().deriveFont(size));
        labelJobStatus.setFont(labelJobStatus.getFont().deriveFont(size));
        labelDate.setFont(labelDate.getFont().deriveFont(size));
        labelDeadline.setFont(labelDeadline.getFont().deriveFont(size));
        labelPrice.setFont(labelPrice.getFont().deriveFont(size));
        labelCustomerAccountNo.setFont(labelCustomerAccountNo.getFont().deriveFont(size));

        btnAddJob.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        removeButton.setPreferredSize(new Dimension(150,30));
        updateButton.setPreferredSize(new Dimension(150,30));
        updateButton3.setPreferredSize(new Dimension(150,30));
        updateButton4.setPreferredSize(new Dimension(150,30));

        //When pressed, system goes back by one screen, using the system's stack of history of pages
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        //If all the text fields are filled in, then the create Job method in the control object is called, using the text from the text fields
        //The if statements are to make sure no blank spaces are entered into the database.
        btnAddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField2.getText().length() > 0) {
                    if (textField3.getText().length() > 0) {
                        if (textField4.getText().length() > 0) {
                            if (textField5.getText().length() > 0) {
                                if (textField6.getText().length() > 0) {
                                    if (textField7.getText().length() > 0) {
                                        if (textField8.getText().length() > 0) {
                                            system.getController().createJob(
                                                    textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
                                                    textField5.getText(), textField6.getText(), textField7.getText(), textField8.getText());

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().length() > 0) {
                    if (textField9.getText().length() > 0) {
                        system.getController().updateJobStartTime(textField1.getText(), textField9.getText());
                    }
                }
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField4.getText().length() > 0) {
                    if (textField9.getText().length() > 0) {
                        system.getController().updateJobStatus(textField4.getText(), textField9.getText());
                    }
                }
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField5.getText().length() > 0) {
                    if (textField9.getText().length() > 0) {
                        system.getController().updateDate(textField5.getText(), textField9.getText());
                    }
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField9.getText().length() > 0) {
                    system.getController().removeJob(textField9.getText());
                }
            }
        });
    }
}
