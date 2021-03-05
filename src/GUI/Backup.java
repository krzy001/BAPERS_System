package GUI;

import Control.BAPERS;

import javax.swing.*;

public class Backup extends Screen{
    private JPanel panelTop;
    private JPanel panelBackup;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnBackup;
    private JButton btnBack;

    public Backup(BAPERS system){
        super(system);
        this.setContentPane(this.panelBackup);
        this.pack();
    }
}
