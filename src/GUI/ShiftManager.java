package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShiftManager extends Screen{
    private JPanel panelShiftManager;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JButton btnReport;
    private JButton backButton;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelTop;
    private JPanel panelFive;

    public ShiftManager(BAPERS system){
        super(system);
        this.setContentPane(this.panelShiftManager);
        this.pack();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
    }
}
