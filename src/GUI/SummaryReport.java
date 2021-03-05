package GUI;

import Control.BAPERS;

import javax.swing.*;

public class SummaryReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextArea SummaryReport;
    private JPanel scrollPane;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelSummaryReport;

    public SummaryReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelSummaryReport);
        this.pack();
    }

}
