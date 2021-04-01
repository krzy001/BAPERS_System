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


    public UrgentJobsList(BAPERS system) {
        super(system);
        this.setContentPane(this.panelUrgent);
        this.pack();

        DefaultTableModel model = new DefaultTableModel(new String[]{
                "Job ID", "Start Time", "Priority", "Special Instructions",
                "Job Status", "Date", "Deadline", "Price",
                "Customer ID"}, 0);

        ArrayList<String> urgentJobs = system.getUrgentJobs();

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            for(int i = 1; i <= urgentJobs.size(); i++) {
                String sql = "SELECT * FROM jobs WHERE Job_No="+urgentJobs.get(i-1);
                PreparedStatement pst = con.prepareStatement(sql);

                ResultSet rs = pst.executeQuery(sql);

                if (rs.next()) {
                    String jobID = rs.getString(1);
                    String startTime = rs.getString(2);
                    String priority = rs.getString(3);
                    String specialInstructions = rs.getString(4);
                    String jobStatus = rs.getString(5);
                    String date = rs.getString(6);
                    String deadline = rs.getString(7);
                    String price = rs.getString(8);
                    String customerID = rs.getString(9);
                    model.addRow(new Object[]{
                            jobID, startTime, priority, specialInstructions,
                            jobStatus, date, deadline, price, customerID});
                }
            }
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
