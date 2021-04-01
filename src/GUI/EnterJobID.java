package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterJobID extends Screen{

    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JLabel labelSearchJob;
    private JTextField textField1;
    private JPanel panelBottom;
    private JButton btnSearch;
    private JButton btnBack;
    private JPanel panelEnterJobID;
    private boolean jobFound;

    public EnterJobID(BAPERS system) {
        super(system);
        this.setContentPane(this.panelEnterJobID);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelSearchJob.setFont(labelLogo.getFont().deriveFont(size));

        btnSearch.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));

        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        //When pressed, system goes back by one screen, using the system's stack of history of pages
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        //when the button is pressed, the search job method is called to check if the ID entered exists in the database.
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobFound = system.getController().searchJob(textField1.getText());

                //If it does exist, the user is taken to a customer sales report relating to that job.
                if(jobFound){
                    system.setID(textField1.getText());
                    system.nextScreen(system.ViewCustomerSalesReport);
                }
                //Otherwise, nothing happens.
            }
        });
    }
}
