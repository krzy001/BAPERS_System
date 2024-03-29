package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordCardPayment extends Screen {
    private JPanel panelTop;
    private JButton btnAddCardPayment;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panelThree;
    private JPanel panelFive;
    private JPanel panelRecordPayment;
    private JButton btnBack;
    private JButton btnLogout;
    private JTextField textField3;
    private JLabel labelLogo;
    private JTextField textField6;
    private JButton updateButton1;
    private JButton updateButton2;
    private JButton updateButton3;
    private JButton updateButton4;
    private JTextField textField7;
    private JLabel labelCardNo;
    private JLabel labelExpiryDate;
    private JLabel labelCardHolderName;
    private JLabel labelPaymentMade;
    private JLabel labelTransactionId;
    private JLabel labelCVV;
    private JButton updateButton;

    public RecordCardPayment(BAPERS system){
        super(system);
        this.setContentPane(this.panelRecordPayment);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelCardNo.setFont(labelLogo.getFont().deriveFont(size));
        labelCardHolderName.setFont(labelLogo.getFont().deriveFont(size));
        labelExpiryDate.setFont(labelLogo.getFont().deriveFont(size));
        labelPaymentMade.setFont(labelLogo.getFont().deriveFont(size));
        labelTransactionId.setFont(labelLogo.getFont().deriveFont(size));
        labelCVV.setFont(labelLogo.getFont().deriveFont(size));


        btnBack.setPreferredSize(new Dimension(150,30));
        btnAddCardPayment.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        updateButton.setPreferredSize(new Dimension(150,30));
        updateButton1.setPreferredSize(new Dimension(150,30));
        updateButton2.setPreferredSize(new Dimension(150,30));
        updateButton3.setPreferredSize(new Dimension(150,30));
        updateButton4.setPreferredSize(new Dimension(150,30));

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

        //If all the text fields are filled in, then the record carh payment method in the control object is called, using the text from the text fields
        //The if statements are to make sure no blank spaces are entered into the database.
        btnAddCardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length()>0) {
                    if (textField2.getText().length() > 0) {
                        if (textField3.getText().length() > 0) {
                            if (textField4.getText().length() > 0) {
                                if (textField5.getText().length() > 0) {
                                    if (textField6.getText().length() > 0) {
                                        system.getController().recordCardPayment(
                                                textField1.getText(),textField2.getText(), textField3.getText(),
                                                textField4.getText(), textField5.getText(), textField6.getText());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().length()>0) {
                    if (textField5.getText().length() > 0) {
                        system.getController().updateCardCardNo(textField1.getText(), textField5.getText());
                    }
                }
            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().length()>0) {
                    if (textField5.getText().length() > 0) {
                        system.getController().updateCardExpiryDate(textField2.getText(), textField5.getText());
                    }
                }
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField3.getText().length()>0) {
                    if (textField5.getText().length() > 0) {
                        system.getController().updateCardHolderName(textField3.getText(), textField5.getText());
                    }
                }
            }
        });
        updateButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField4.getText().length()>0) {
                    if (textField5.getText().length() > 0) {
                        system.getController().updateCardPaid(textField4.getText(), textField5.getText());
                    }
                }
            }
        });
        updateButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField6.getText().length()>0) {
                    if (textField5.getText().length() > 0) {
                        system.getController().updateCardCVV(textField6.getText(), textField5.getText());
                    }
                }
            }
        });
    }
}
