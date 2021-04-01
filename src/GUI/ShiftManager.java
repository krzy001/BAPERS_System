package GUI;

import Control.BAPERS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShiftManager extends Screen{
    private JPanel panelShiftManager;
    private JButton btnCreateCustomer;
    private JButton btnIdentifyCustomer;
    private JButton btnSearchTask;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelTop;
    private JPanel panelFive;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton addJobButton;
    private JButton searchJobButton;
    private JButton addTaskButton;
    private JButton taskListButton;
    private JButton jobListButton;
    private JButton reportButton;
    private JButton searchPaymentButton;
    private JButton paymentListButton;

    public ShiftManager(BAPERS system){
        super(system);
        this.setContentPane(this.panelShiftManager);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        float size = 20;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnCreateCustomer.setPreferredSize(new Dimension(150,30));
        btnIdentifyCustomer.setPreferredSize(new Dimension(150,30));
        btnLogout.setPreferredSize(new Dimension(150,30));
        btnSearchTask.setPreferredSize(new Dimension(150,30));
        addJobButton.setPreferredSize(new Dimension(150,30));
        addTaskButton.setPreferredSize(new Dimension(150,30));
        taskListButton.setPreferredSize(new Dimension(150,30));
        jobListButton.setPreferredSize(new Dimension(150,30));
        reportButton.setPreferredSize(new Dimension(150,30));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  ;
        LocalDate now = LocalDate.now();
        String date = dtf.format(now);

        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));

        if(!system.isUrgentJobsShown()) {
            try {
                String sql = "SELECT * FROM jobs WHERE Job_Status != 'Completed'";
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement s = con.prepareStatement(sql);
                ResultSet rs = s.executeQuery(sql);

                while (rs.next()) {
                    String jobID = rs.getString(1);
                    String deadline = rs.getString(7);

                    int deadlineDay = Integer.parseInt(deadline.substring(8, 10));
                    int deadlineMonth = Integer.parseInt(deadline.substring(5, 7));
                    int deadlineYear = Integer.parseInt(deadline.substring(0, 4));

                    if (deadlineYear <= year) {
                        if (deadlineMonth <= month) {
                            if (deadlineDay <= day) {
                                system.addUrgentJobs(jobID);
                                system.setUrgentJobsShown(true);
                            }
                        }
                    }
                }

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }

            if (system.getUrgentJobs().size() > 0) {
                system.nextScreen(system.UrgentJobsList);
            }
        }

        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        btnCreateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateCustomerAccount);
            }
        });
        btnIdentifyCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyCustomer);
            }
        });
        addJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
        searchJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchJob);
            }
        });
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
            }
        });
        btnSearchTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchTask);
            }
        });
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobList);
            }
        });
        searchPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.SearchPayment);
            }
        });
        paymentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.PaymentList);
            }
        });
    }
}