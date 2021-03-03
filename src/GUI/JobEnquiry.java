package GUI;

import javax.swing.*;

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

    public JobEnquiry(){
        this.setContentPane(this.panelEnquiry);
        this.pack();
    }
}
