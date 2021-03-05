package GUI;

import Control.BAPERS;

import javax.swing.*;

public class IndividualJobReport extends Screen {
    private JPanel panelTop;
    private JButton btnPrint;
    private JTextArea IndividualJobReport;
    private JPanel panelMiddle;
    private JPanel panelIndividualJobReport;
    private JPanel panelBottom;
    private JPanel scrollPane;

    public IndividualJobReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualJobReport);
        this.pack();
    }
}
