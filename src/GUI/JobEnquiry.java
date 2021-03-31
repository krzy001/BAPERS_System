package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobEnquiry extends Screen {
    private JPanel panelEnquiry;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JTextField textField2;
    private JButton btnSend;
    private JPanel panelButton;
    private JButton btnBack;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JLabel labelQuestionHeader;
    private JLabel labelResponse;
    private JLabel labelQuestion;

    public JobEnquiry(BAPERS system){
        super(system);
        this.setContentPane(this.panelEnquiry);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelQuestionHeader.setFont(labelLogo.getFont().deriveFont(size));
        labelResponse.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnSend.setPreferredSize(new Dimension(150,30));

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
