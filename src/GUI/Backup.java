package GUI;

import javax.swing.*;

public class Backup extends Screen{
    private JPanel panelTop;
    private JPanel panelBackup;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JButton btnBackup;
    private JButton btnBack;

    public Backup(){
        this.setContentPane(this.panelBackup);
        this.pack();
    }
}
