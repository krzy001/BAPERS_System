package GUI;

import Control.BAPERS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class UrgentJobsList extends Screen {
    private JButton backBtn;
    private JButton logOutButton;
    private JTable jobsTable;
    private JPanel panelUrgent;
    private JButton backButton;


    //Class to display the list of urgent jobs that need to be completed
    public UrgentJobsList(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUrgent);
        this.pack();

        //model is created with headers for the urgent jobs lost
        DefaultTableModel model = new DefaultTableModel(new String[]{
                "Job ID", "Start Time", "Priority", "Special Instructions",
                "Job Status", "Date", "Deadline", "Price",
                "Customer ID"}, 0);

        //Get the list of urgent jobs
        ArrayList<String> urgentJobs = system.getUrgentJobs();

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            //Select all jobs with job ID that is in the urgent jobs list
            for(int i = 1; i <= urgentJobs.size(); i++) {
                String sql = "SELECT * FROM jobs WHERE Job_No="+urgentJobs.get(i-1);
                PreparedStatement pst = con.prepareStatement(sql);

                ResultSet rs = pst.executeQuery(sql);

                //For every job found...
                if (rs.next()) {
                    //Establish variables with the attributes retrieved
                    String jobID = rs.getString(1);
                    String startTime = rs.getString(2);
                    String priority = rs.getString(3);
                    String specialInstructions = rs.getString(4);
                    String jobStatus = rs.getString(5);
                    String date = rs.getString(6);
                    String deadline = rs.getString(7);
                    String price = rs.getString(8);
                    String customerID = rs.getString(9);
                    //Add a row with the variables in the model
                    model.addRow(new Object[]{
                            jobID, startTime, priority, specialInstructions,
                            jobStatus, date, deadline, price, customerID});
                }
            }
            //Set the model in the jTable for it to be displayed on screen
            jobsTable.setModel(model);
        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(null,"Error Occurred");
        }
        //When pressed, system goes back by one screen, using the system's stack of history of pages
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
    }
}
