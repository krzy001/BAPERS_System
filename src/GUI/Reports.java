package GUI;

import Control.BAPERS;

import javax.swing.*;

public class Reports extends Screen {
    private JPanel panelReports;
    private JPanel panelTop;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JButton btnView1;
    private JButton btnIndividualJobReport;
    private JButton btnPrint1;
    private JButton btnView2;
    private JButton btnPrint2;
    private JButton btnIndividualPerformanceReport;
    private JButton btnView3;
    private JButton btnPrint3;
    private JButton btnSummaryReport;
    private JPanel panelBottom;
    private JButton btnBack;

    public Reports(BAPERS system){
        super(system);
        this.setContentPane(this.panelReports);
        this.pack();
    }
}
