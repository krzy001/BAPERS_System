package GUI;

import javax.swing.*;

public class SummaryReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextArea SummaryReport;
    private JPanel scrollPane;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelSummaryReport;

    public SummaryReport() {
        this.setContentPane(this.panelSummaryReport);
        this.pack();
    }

}
