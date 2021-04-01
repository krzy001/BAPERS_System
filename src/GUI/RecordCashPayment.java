package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordCashPayment extends Screen{
    private JPanel panelRecordCashPayment;
    private JPanel panelTop;
    private JLabel labelLogo;
    private JButton btnLogout;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panelFive;
    private JButton btnAddCashPayment;
    private JButton btnBack;
    private JButton updateButton;
    private JLabel labelPaymentMade;
    private JLabel labelTransactionId;

    public RecordCashPayment(BAPERS system) {
        super(system);
        this.setContentPane(this.panelRecordCashPayment);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelPaymentMade.setFont(labelLogo.getFont().deriveFont(size));
        labelTransactionId.setFont(labelLogo.getFont().deriveFont(size));

        btnBack.setPreferredSize(new Dimension(150,30));
        panelRecordCashPayment.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnAddCashPayment.setPreferredSize(new Dimension(150,30));
        updateButton.setPreferredSize(new Dimension(150,30));

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

        //If all the text fields are filled in, then the create cash payment method in the control object is called, using the text from the text fields
        //The if statements are to make sure no blank spaces are entered into the database.
        btnAddCashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().length()>0) {
                    if (textField3.getText().length() > 0) {
                        system.getController().recordCashPayment(
                                textField2.getText(), textField3.getText());
                    }
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField2.getText().length() > 0) {
                    if (textField3.getText().length() > 0) {
                        system.getController().updateCashPaymentPaid(textField2.getText(), textField3.getText());
                    }
                }
            }
        });
    }
}
