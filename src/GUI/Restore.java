package GUI;

import Control.BAPERS;

import javax.swing.*;

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

    public Restore(BAPERS system){
        super(system);
        this.setContentPane(this.panelRestore);
        this.pack();
    }
}
