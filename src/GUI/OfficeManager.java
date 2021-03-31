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

public class OfficeManager extends Screen {
    private JPanel panelOfficeManager;
    private JPanel panelTop;
    private JButton btnReport;
    private JPanel panelBottom;
    private JButton btnLogOut;
    private JButton addJobButton;
    private JLabel labelLogo;
    private JButton searchCustomerButton;
    private JButton createCustomerButton;
    private JButton searchUserButton;
    private JButton createUserButton;
    private JButton addTaskButton;
    private JButton jobListButton;
    private JButton taskListButton;
    private JButton backupButton;
    private JButton restoreButton;
    private JLabel labelOfficeManager;
    private JButton searchPaymentButton;
    private JButton paymentListButton;
    private JButton staffListButton;

    public OfficeManager(BAPERS system){
        super(system);
        this.setContentPane(this.panelOfficeManager);
        this.pack();
        float logo = 80;
        float size = 30;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);
        labelOfficeManager.setFont(labelLogo.getFont().deriveFont(size));

        btnReport.setPreferredSize(new Dimension(250,50));
        btnLogOut.setPreferredSize(new Dimension(250,50));
        addJobButton.setPreferredSize(new Dimension(250,50));
        addTaskButton.setPreferredSize(new Dimension(250,50));
        searchCustomerButton.setPreferredSize(new Dimension(250,50));
        createCustomerButton.setPreferredSize(new Dimension(250,50));
        searchUserButton.setPreferredSize(new Dimension(250,50));
        createUserButton.setPreferredSize(new Dimension(250,50));
        addTaskButton.setPreferredSize(new Dimension(250,50));
        jobListButton.setPreferredSize(new Dimension(250,50));
        taskListButton.setPreferredSize(new Dimension(250,50));
        backupButton.setPreferredSize(new Dimension(250,50));
        restoreButton.setPreferredSize(new Dimension(250,50));

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

        searchCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyCustomer);
            }
        });
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateCustomerAccount);
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.CreateNewUser);
            }
        });
        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Backup);
            }
        });
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {system.nextScreen(system.Restore);}
        });
        searchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.IdentifyUser);
            }
        });
        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Reports);
            }
        });
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        addJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddJob);
            }
        });
        jobListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.JobList);
            }
        });
        taskListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.TaskList);
            }
        });
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.AddTask);
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
        staffListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.StaffList);
            }
        });
    }
}
