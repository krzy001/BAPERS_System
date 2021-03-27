package GUI;

import Control.BAPERS;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewIndividualPerformanceReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JPanel scrollPane;
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

        //DefaultTableModel model = system.generateIndividualPerformanceReport();

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
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);
                    //String sql = "SELECT staff.Name,task.Task_ID,staff.Department,task.Date,task.Start_Time,task.Time_Taken FROM task INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID";
                    String sql = "SELECT * FROM task";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);

                    Workbook w = new XSSFWorkbook();

                    FileOutputStream file = new FileOutputStream("Individual Performance Report.xlsx");

                    Sheet s = w.createSheet("Individual Performance Report");
                    String[] headers = {"Name", "Task Id", "Department", "Date", "Start Time", "Time Taken"};
                    ArrayList<String> Name = new ArrayList<>();
                    ArrayList<Integer> TaskId = new ArrayList<>();
                    ArrayList<String> Department = new ArrayList<>();
                    ArrayList<String> Date = new ArrayList<>();
                    ArrayList<String> StartTime = new  ArrayList<>();
                    ArrayList<String> TimeTaken = new ArrayList<>();

                    Row row = s.createRow(0);

                    while (rs.next()) {
                        Name.add(rs.getString(9));
                        TaskId.add(rs.getInt(1));
                        Department.add(rs.getString(3));
                        Date.add(rs.getString(7));
                        StartTime.add(rs.getString(7));
                        TimeTaken.add(rs.getString(5));


                        int rowNum = 1;
                        /*
                        for(int i = 0; i < Name.size(); ++i){
                            row = s.createRow(rowNum++);
                            row.createCell(0).setCellValue(1);
                            row.createCell(1).setCellValue(2);
                            row.createCell(2).setCellValue(3);
                            row.createCell(3).setCellValue(4);
                            row.createCell(4).setCellValue(5);
                            row.createCell(5).setCellValue(6);
                        }

                         */
                       for(int i = 0; i < Name.size(); ++i){
                            row = s.createRow(rowNum++);
                            row.createCell(0).setCellValue(Name.get(i));
                            row.createCell(1).setCellValue(TaskId.get(i));
                            row.createCell(2).setCellValue(Department.get(i));
                            row.createCell(3).setCellValue(Date.get(i));
                            row.createCell(4).setCellValue(StartTime.get(i));
                            row.createCell(5).setCellValue(TimeTaken.get(i));
                        }

                    }
                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = row.createCell(i);
                        cell.setCellValue(headers[i]);
                        w.write(file);
                    }
                    file.close();
                }

                catch(Exception e1){
                    e1.printStackTrace();
                }

            }
        });
    }
}
