package GUI;

import Control.BAPERS;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;

public class ViewIndividualPerformanceReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelIndividualPerformanceReport;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JTable table1;
    private JButton printButton;

    public ViewIndividualPerformanceReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualPerformanceReport);
        this.pack();

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        printButton.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model = system.generateIndividualPerformanceReport();
        table1.setModel(model);

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
        //When pressed, the system creates an excel sheet with the report information for the user to print
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);

                    //Select all the necessary  attributes from staff and task for the report
                    //links the two tables by matching the staff ID on task is equal to the staff ID of staff
                    String sql = "SELECT\n" +
                            "  staff.Name,\n" +
                            "  staff.Department,\n" +
                            "  task.Task_ID,\n" +
                            "  task.Time_Taken,\n" +
                            "  task.Date,\n" +
                            "  task.Start_Time,\n" +
                            " staff.Staff_ID\n" +
                            " FROM task\n" +
                            "  INNER JOIN staff\n" +
                            "    ON task.StaffStaff_Id = staff.Staff_ID\n" +
                            "ORDER BY staff.Staff_ID ASC";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);

                    //initialising workbook
                    Workbook w = new XSSFWorkbook();
                    Sheet s = w.createSheet("Individual Performance Report");
                    //Establish headers for the report
                    String[] headers = {"Name", "Task Id", "Department", "Date", "Start Time", "Time Taken", "Total Time"};
                    Row row = s.createRow(0);

                    // creates headers for the excel file
                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = row.createCell(i);
                        cell.setCellValue(headers[i]);
                    }

                    int TotalEffort = 0;
                    int numRows = 0;

                    //For every row of attributes...
                    while (rs.next()) {
                        //All attributes are saved as variables
                        String Name = rs.getString(1);
                        String Department = rs.getString(2);
                        String TaskId = rs.getString(3);
                        int TimeTaken = rs.getInt(4);
                        String Date = rs.getString(5);
                        String StartTime = rs.getString(6);
                        int staffID = rs.getInt(7);


                        numRows += 1;

                        //Create a row and insert all the attributes in cells of the row
                        row = s.createRow(numRows);
                        row.createCell(0).setCellValue(Name);
                        row.createCell(1).setCellValue(TaskId);
                        row.createCell(2).setCellValue(Department);
                        row.createCell(3).setCellValue(Date);
                        row.createCell(4).setCellValue(StartTime);
                        row.createCell(5).setCellValue(TimeTaken);
                        row.createCell(6).setCellValue(getHours(staffID));

                        //Total effort is updated with time taken to keep a record of the total effort for the report
                        TotalEffort += TimeTaken;

                    }

                    //At the bottom of the report, a row for total effort is added
                    row = s.createRow(numRows + 1);
                    row.createCell(0).setCellValue("Total effort:");
                    row.createCell(6).setCellValue(TotalEffort);

                    //File is created for the workbook to be written in the file, then the file closes
                    FileOutputStream file = new FileOutputStream(new File("Individual Performance Report.xlsx"));
                    w.write(file);
                    file.close();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,"Error Occurred");
                }
            }

            //Method to receive the total time of a staff member related to the report
            public int getHours(int id) {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);

                    String query = ("SELECT Sum(task.Time_Taken), staffStaff_ID\n" +
                            "FROM Task \n" +
                            "INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID\n" +
                            "WHERE task.StaffStaff_Id='" + id + "'");
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet data = st.executeQuery(query);
                    if (data.next()) {
                        return data.getInt(1);
                    }
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null,"Error Occurred");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return 0;
            }
        });
    }
}
