package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restore extends Screen {
    private JPanel panelTop;
    private JPanel panelRestore;
    private JList listRestoreDatabase;
    private JButton btnGo;
    private JButton btnBack;
    private JButton btnRestore;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JButton btnLogout;

    public Restore(BAPERS system){
        super(system);
        this.setContentPane(this.panelRestore);
        this.pack();

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
