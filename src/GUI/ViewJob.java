package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;

public class ViewJob extends Screen {
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
    private JButton jobListButton;
    private JButton changeButton;
    private JButton removeButton;
    private JPanel panelViewJob;

    public ViewJob(BAPERS system, String jobNo) {
        super(system);
        this.setContentPane(this.panelViewJob);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
    }
}
