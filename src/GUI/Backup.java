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
        //Font and size of buttons established for the interface
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnBackup.setPreferredSize(new Dimension(400,150));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));

        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        //When pressed, system goes back by one screen, using the system's stack of history of pages
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });

        //when the button is pressed, the method backupDatabase is called with the control object to back up the database
        btnBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getController().backupDatabase();
            }
        });
    }

}
