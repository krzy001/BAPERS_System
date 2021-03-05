package GUI;

import Control.BAPERS;

import javax.swing.*;

public class Technician extends Screen {
    private JPanel panelTechnician;
    private JPanel panelTop;
    private JButton btnJobEnquiry;
    private JButton btnResponse;
    private JButton btnBack;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelBottom;

    public Technician(BAPERS system){
        super(system);
        this.setContentPane(this.panelTechnician);
        this.pack();
    }
}
