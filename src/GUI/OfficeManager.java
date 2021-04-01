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

        //Font and size of buttons established for the interface
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
        searchPaymentButton.setPreferredSize(new Dimension(250,50));
        paymentListButton.setPreferredSize(new Dimension(250,50));
        staffListButton.setPreferredSize(new Dimension(250,50));

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

                    if (deadlineYear < year) {
                        system.addUrgentJobs(jobID);
                        system.setUrgentJobsShown(true);
                    }
                    else if(deadlineYear == year){
                        if (deadlineMonth < month) {
                            system.addUrgentJobs(jobID);
                            system.setUrgentJobsShown(true);
                        }
                        else if(deadlineMonth == month)
                            if (deadlineDay <= day) {
                                system.addUrgentJobs(jobID);
                                system.setUrgentJobsShown(true);
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
            public void actionPerformed(ActionEvent e) {
                system.nextScreen(system.Restore);
            }
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
        //When pressed, system logs the user out, resetting certain attributes of the system object in the process
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
