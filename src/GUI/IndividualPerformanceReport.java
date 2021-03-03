package GUI;

import javax.swing.*;

public class IndividualPerformanceReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JTextArea IndividualPerformanceReport;
    private JPanel scrollPane;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelIndividualPerformanceReport;

    public IndividualPerformanceReport() {
        this.setContentPane(this.panelIndividualPerformanceReport);
        this.pack();
    }
}
