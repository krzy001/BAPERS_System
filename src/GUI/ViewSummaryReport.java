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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewSummaryReport extends Screen {
    private JPanel panelTop;
    private JPanel panelMiddle;
    private JButton btnBack;
    private JPanel panelBottom;
    private JPanel panelSummaryReport;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JTable table1;
    private JButton printButton;
    private JButton dayShift1Button;
    private JButton nightShiftButton;
    private JButton dayShift2Button;
    private JButton pickDatesButton;

    public ViewSummaryReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelSummaryReport);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        printButton.setPreferredSize(new Dimension(150,30));

        DefaultTableModel day1Model = system.generateSummaryReport();
        DefaultTableModel day2Model = system.generateSummaryReport();
        DefaultTableModel nightModel = system.generateSummaryReport();
        //DefaultTableModel periodModel = system.generateSummaryReport();

        table1.setModel(day1Model);

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

                Workbook w = new XSSFWorkbook();

                Sheet s = w.createSheet("Summary Report");
                String[] headers = {"Date", "Copy Room", "Development", "Finishing", "Packing"};
                Row row = s.createRow(0);

                for (int i = 0; i < headers.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(headers[i]);
                }


                try {
                    FileOutputStream file = new FileOutputStream(new File("Summary Report.xlsx"));
                    w.write(file);
                    file.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                /*
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);
                    String sql = "SELECT staff.Name,task.Task_ID,staff.Department,task.Date,task.Start_Time,task.Time_Taken FROM task INNER JOIN staff ON task.StaffStaff_Id = staff.Staff_ID";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);


                    ArrayList<String> Date = new ArrayList<>();
                    ArrayList<String> Location = new ArrayList<>();
                    ArrayList<String> Development = new ArrayList<>();
                    ArrayList<String> Finishing = new ArrayList<>();
                    ArrayList<String> Packing = new  ArrayList<>();

                    while (rs.next()) {
                        Date.add(rs.getString(1));
                        Location.add(rs.getString(2));
                        Development.add(rs.getString(3));
                        Finishing.add(rs.getString(4));
                        Packing.add(rs.getString(5));

                        int rowNum = 1;

                        for(int i = 0; i < Date.size(); ++i){
                            row = s.createRow(rowNum++);
                            row.createCell(0).setCellValue(Date.get(i));
                            row.createCell(1).setCellValue(Location.get(i));
                            row.createCell(2).setCellValue(Development.get(i));
                            row.createCell(3).setCellValue(Finishing.get(i));
                            row.createCell(4).setCellValue(Packing.get(i));
                        }

                    }

                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
                 */
            }
        });

        dayShift1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(day1Model);
            }
        });

        dayShift2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(day2Model);
            }
        });

        nightShiftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(nightModel);
            }
        });
    }

}
