package GUI;

import Control.BAPERS;

import javax.swing.*;
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

    public Backup(BAPERS system){
        super(system);
        this.setContentPane(this.panelBackup);
        this.pack();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("LI");
            }
        });
    }

}
