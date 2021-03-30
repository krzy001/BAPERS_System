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
    ArrayList<Integer> StaffHours = new ArrayList<>();
    ArrayList<Integer> StaffID = new ArrayList<>();
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
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        printButton.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model = system.generateIndividualPerformanceReport();
        table1.setModel(model);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.LogOut();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.backScreen();
            }
        });
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Integer> TotalStaff = new ArrayList<>();
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);


                    //String sql = "SELECT staff.Name,task.Task_ID,staff.Department,task.Date,task.Start_Time,task.Time_Taken,Sum(task.Time_Taken) FROM task INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID";
                    String sql = "SELECT\n" +
                            "  staff.Name,\n" +
                            "  staff.Department,\n" +
                            "  task.Task_ID,\n" +
                            "  task.Time_Taken,\n" +
                            "  task.Date,\n" +
                            "  task.Start_Time\n" +
                            "FROM task\n" +
                            "  INNER JOIN staff\n" +
                            "    ON task.StaffStaff_Id = staff.Staff_ID\n" +
                            "ORDER BY staff.Staff_ID ASC";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);

                    //initialising workbook - ignore
                    Workbook w = new XSSFWorkbook();
                    Sheet s = w.createSheet("Individual Performance Report");
                    String[] headers = {"Name", "Task Id", "Department", "Date", "Start Time", "Time Taken", "Total Time"};
                    Row row = s.createRow(0);

                    // creates headers for the excel file
                    for (int i = 0; i < headers.length; i++)
                    {
                        Cell cell = row.createCell(i);
                        cell.setCellValue(headers[i]);
                    }

                    /*
                    ArrayList<String> Name = new ArrayList<>();
                    ArrayList<Integer> TaskId = new ArrayList<>();
                    ArrayList<String> Department = new ArrayList<>();
                    ArrayList<String> Date = new ArrayList<>();
                    ArrayList<String> StartTime = new  ArrayList<>();
                    ArrayList<Integer> TimeTaken = new ArrayList<>();
                    ArrayList<String> TotalTimeTaken = new ArrayList<>();
                    */
                    int TotalEffort = 0;

                    int numRows = 0;

                    getStaffID();

                    while (rs.next()) {
                        /*
                        Name.add(rs.getString(1));
                        TaskId.add(rs.getInt(3));
                        Department.add(rs.getString(2));
                        Date.add(rs.getString(5));
                        StartTime.add(rs.getString(6));
                        TimeTaken.add(rs.getInt(4));

                         */
                        String Name = rs.getString(1);
                        String Department = rs.getString(2);
                        String TaskId = rs.getString(3);
                        int TimeTaken = rs.getInt(4);
                        String Date = rs.getString(5);
                        String StartTime = rs.getString(6);


                        numRows+=1;

                        row = s.createRow(numRows);
                        row.createCell(0).setCellValue(Name);
                        row.createCell(1).setCellValue(TaskId);
                        row.createCell(2).setCellValue(Department);
                        row.createCell(3).setCellValue(Date);
                        row.createCell(4).setCellValue(StartTime);
                        row.createCell(5).setCellValue(TimeTaken);
                        row.createCell(6).setCellValue(StaffHours.get(numRows-1));

                        TotalEffort+=TimeTaken;

                        /*
                        int rowNum = 1;

                       for(int i = 0; i < Name.size(); ++i)
                       {
                            row = s.createRow(rowNum++);
                            row.createCell(0).setCellValue(Name.get(i));
                            row.createCell(1).setCellValue(TaskId.get(i));
                            row.createCell(2).setCellValue(Department.get(i));
                            row.createCell(3).setCellValue(Date.get(i));
                            row.createCell(4).setCellValue(StartTime.get(i));
                            row.createCell(5).setCellValue(TimeTaken.get(i));
                            row.createCell(6).setCellValue(StaffHours.get(i));
                        }

                         */

                    }

                    row = s.createRow(numRows+1);
                    row.createCell(0).setCellValue("Total effort:");
                    row.createCell(6).setCellValue(TotalEffort);

                    FileOutputStream file = new FileOutputStream(new File("Individual Performance Report.xlsx"));
                    w.write(file);
                    file.close();
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
            public void getStaffID()
            {
                try
                {
                    //Connection IGNORE
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);

                    String sql = ("select Staff_ID from staff");
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);
                    while(rs.next())
                    {
                        StaffID.add(rs.getInt(1));
                    }

                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < StaffID.size(); i++)
                {

                    getHours(StaffID.get(i));
                }
            }

            public void getHours(int id)
            {
                try
                {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);

                    String query = ("SELECT Sum(task.Time_Taken), staffStaff_ID\n" +
                            "FROM Task \n" +
                            "INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID\n" +
                            "WHERE task.StaffStaff_Id='" +id + "'");
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet data = st.executeQuery(query);
                    while(data.next())
                    {
                        StaffHours.add(data.getInt(1));
                    }

                    for (int i = 0; i < StaffHours.size(); i++)
                    {
                        System.out.println(StaffHours.get(i));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
