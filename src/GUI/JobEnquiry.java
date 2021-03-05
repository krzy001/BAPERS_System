package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobEnquiry extends Screen {
    private JPanel panelEnquiry;
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel panelBottom;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnSend;
    private JPanel panelButton;
    private JButton btnBack;
    private JButton btnLogout;

    public JobEnquiry(BAPERS system){
        super(system);
        this.setContentPane(this.panelEnquiry);
        this.pack();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen("LI");
            }
        });
    }
}
