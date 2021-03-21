package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;

public class ViewTask extends Screen {
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JPanel panelMiddle;
    private JLabel jLabelName;
    private JLabel jLabelContactName;
    private JLabel jLabelAddress;
    private JLabel jLabelPhone;
    private JLabel jLabelEmail;
    private JLabel jLabelDiscountPlan;
    private JLabel jLabelValued;
    private JPanel panelBottom;
    private JButton btnBack;
    private JButton btnAddJob;
    private JButton taslkListButton;
    private JButton changeButton;
    private JButton removeButton;
    private JPanel panelViewTask;

    public ViewTask(BAPERS system, String taskId) {
        super(system);
        this.setContentPane(this.panelViewTask);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
    }
}
