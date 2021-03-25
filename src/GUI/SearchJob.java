package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchJob extends Screen {

    private JPanel panelSearchJob;
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JTextField textField1;
    private JPanel panelBottom;
    private JButton btnSearch;
    private JButton btnBack;
    private JLabel labelSearchJob;
    private boolean jobFound;

    public SearchJob(BAPERS system) {
        super(system);
        this.setContentPane(this.panelSearchJob);
        this.pack();
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelSearchJob.setFont(labelLogo.getFont().deriveFont(size));

        btnSearch.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));

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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobFound = system.getController().searchJob(textField1.getText());

                if(jobFound){
                    system.setID(textField1.getText());
                    system.nextScreen(system.ViewJob);
                }
            }
        });
    }
}
