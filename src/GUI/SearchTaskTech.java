package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchTaskTech extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JLabel labelSearchTask;
    private JTextField textField1;
    private JPanel panelBottom;
    private JButton btnSearch;
    private JButton btnBack;
    private JPanel panelSearchTask;
    private boolean taskFound;

    public SearchTaskTech(BAPERS system) {
        super(system);
        this.setContentPane(this.panelSearchTask);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelSearchTask.setFont(labelLogo.getFont().deriveFont(size));

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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskFound = system.getController().searchTask(textField1.getText());

                if(taskFound){
                    system.setID(textField1.getText());
                    system.nextScreen(system.ViewTaskTech);
                }
            }
        });
    }
}
