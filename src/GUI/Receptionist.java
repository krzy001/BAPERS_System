package GUI;

import Control.BAPERS;

import javax.swing.*;

public class Receptionist extends Screen{
    private JPanel panelReceptionist;
    private JPanel panelTop;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JButton btnBack;

    public Receptionist(BAPERS system){
        super(system);
        this.setContentPane(this.panelReceptionist);
        this.pack();
    }
}
