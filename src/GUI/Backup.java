package GUI;

import Control.BAPERS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Backup extends Screen{
    private JPanel panelTop;
    private JPanel panelBackup;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnBackup;
    private JButton btnBack;
    private JButton btnLogout;
    private JLabel labelLogo;

    public Backup(BAPERS system){
        super(system);
        this.setContentPane(this.panelBackup);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnBackup.setPreferredSize(new Dimension(400,150));
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
        btnBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().backupDatabase();
            }
        });
    }

}
