package GUI;

import Control.BAPERS;

import javax.swing.*;

public class JobsList extends Screen{
    private JPanel panelTop;
    private JList list1;
    private JButton btnBack;
    private JButton btnAddJob;
    private JPanel panelJobsList;
    private JPanel panelMiddle;
    private JPanel panelBottom;

    public JobsList(BAPERS system){
        super(system);
        this.setContentPane(this.panelJobsList);
        this.pack();
    }
}
