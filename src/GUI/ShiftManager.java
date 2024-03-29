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

        btnCreateCustomer.setPreferredSize(new Dimension(250,50));
        btnIdentifyCustomer.setPreferredSize(new Dimension(250,50));
        btnLogout.setPreferredSize(new Dimension(250,50));
        btnSearchTask.setPreferredSize(new Dimension(250,50));
        searchJobButton.setPreferredSize(new Dimension(250,50));
        addJobButton.setPreferredSize(new Dimension(250,50));
        addTaskButton.setPreferredSize(new Dimension(250,50));
        taskListButton.setPreferredSize(new Dimension(250,50));
        jobListButton.setPreferredSize(new Dimension(250,50));
        reportButton.setPreferredSize(new Dimension(250,50));
        searchPaymentButton.setPreferredSize(new Dimension(250,50));
        paymentListButton.setPreferredSize(new Dimension(250,50));

        //Everytime the user logs in as office manager, the deadline dates are checked for any urgent jobs that need to be complete.

        //The date of the system is taken
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  ;
        LocalDate now = LocalDate.now();
        String date = dtf.format(now);

        //The date of the system is converted into three separate strings for day, month, and year
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));

        //If the urgent jobs list has not already been shown
        if(!system.isUrgentJobsShown()) {
            try {
                //Select all jobs where the job status is not complete
                String sql = "SELECT * FROM jobs WHERE Job_Status != 'Completed'";
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement s = con.prepareStatement(sql);
                ResultSet rs = s.executeQuery(sql);

                //For every job found
                while (rs.next()) {
                    //Necessary attributes saved as variables
                    String jobID = rs.getString(1);
                    String deadline = rs.getString(7);

                    //The deadline date is converted into three variables for the day, month, and year.
                    int deadlineDay = Integer.parseInt(deadline.substring(8, 10));
                    int deadlineMonth = Integer.parseInt(deadline.substring(5, 7));
                    int deadlineYear = Integer.parseInt(deadline.substring(0, 4));

                    //The current date and deadline date are compared together
                    //If the deadline is the same, or gone past, its added to the list of urgent jobs to show

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

            //If the list of urgent jobs is greater than 0, the urgent jobs list is shown in a separate window
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
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Reports);
            }
        });
    }
}