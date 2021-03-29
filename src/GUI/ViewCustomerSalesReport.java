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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewCustomerSalesReport extends Screen {
    private JPanel panelTop;
    private JButton btnBack;
    private JPanel panelMiddle;
    private JPanel panelIndividualJobReport;
    private JPanel panelBottom;
    private JButton btnLogout;
    private JLabel labelLogo;
    private JButton printButton;
    private JTable table1;

    public ViewCustomerSalesReport(BAPERS system) {
        super(system);
        this.setContentPane(this.panelIndividualJobReport);
        this.pack();
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        printButton.setPreferredSize(new Dimension(150,30));

        DefaultTableModel model = system.generateCustomerSalesReport();
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
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);
                    //String sql = "SELECT * FROM task WHERE JobsJob_No =";
                    String sql = "SELECT task.Task_ID,task.Price,Sum(task.Price) FROM task INNER JOIN jobs ON task.JobsJob_No = jobs.Job_No";
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);

                    Workbook w = new XSSFWorkbook();

                    Sheet s = w.createSheet("Customer Sales Report");
                    String[] headers = {"Task Id", "Price"};
                    Row row = s.createRow(0);

                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = row.createCell(i);
                        cell.setCellValue(headers[i]);
                    }

                    ArrayList<String> TaskID = new ArrayList<>();
                    ArrayList<String> Price = new ArrayList<>();
                    ArrayList<Double> subTotal = new ArrayList<>();
                    subTotal.add(rs.getDouble(3));
                    String discountRate = "0%";
                    double total = (subTotal.get(0) *1.20);
                    int numRows = 1;

                    while (rs.next()) {
                        TaskID.add(rs.getString(1));
                        Price.add(rs.getString(2));

                        int rowNum = 1;

                        for(int i = 0; i < TaskID.size(); ++i){
                            row = s.createRow(rowNum++);
                            row.createCell(0).setCellValue(TaskID.get(i));
                            row.createCell(1).setCellValue(Price.get(i));
                            numRows+=1;
                        }
                    }

                    row = s.createRow(numRows+1);
                    row.createCell(0).setCellValue("Sub-Total");
                    row.createCell(1).setCellValue(subTotal.get(0));

                    row = s.createRow(numRows+2);
                    row.createCell(0).setCellValue("Discount agreed:");
                    row.createCell(1).setCellValue(discountRate);

                    row = s.createRow(numRows+3);
                    row.createCell(0).setCellValue("Total Payable (VAT at 20%)");
                    row.createCell(1).setCellValue(total);

                    FileOutputStream file = new FileOutputStream(new File("Customer Sales Report.xlsx"));
                    w.write(file);
                    file.close();
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }
}
