package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Discount extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelBottom;
    private JButton btnCreate;
    private JButton btnBack;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panelOne;
    private JPanel panelTwo;
    private JPanel panelId;
    private JTextField textField3;
    private JButton updateButton;
    private JPanel panelDiscount;
    private JLabel labelDiscountId;
    private JLabel labelRate;
    private JLabel labelAccountNo;
    private JButton removeButton;

    public Discount(BAPERS system) {
        super(system);
        this.setContentPane(this.panelDiscount);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelDiscountId.setFont(labelLogo.getFont().deriveFont(size));
        labelRate.setFont(labelLogo.getFont().deriveFont(size));
        labelAccountNo.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnCreate.setPreferredSize(new Dimension(150,30));
        updateButton.setPreferredSize(new Dimension(150,30));
        removeButton.setPreferredSize(new Dimension(150,30));

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length()>0){
                    if(textField2.getText().length()>0) {
                        system.getController().addDiscount(
                                textField1.getText(), textField2.getText());
                    }
                }
            }
        });

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

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length()>0) {
                    if (textField3.getText().length() > 0) {
                        system.getController().updateRate(textField1.getText(), textField3.getText());
                    }
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField3.getText().length()>0) {
                    system.getController().removeDiscount(textField3.getText());
                }
            }
        });
    }
}
