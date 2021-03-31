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
import java.sql.*;
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
    double discountRate = 1;

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

                    String sql = "SELECT task.Task_ID,task.Price FROM task INNER JOIN jobs ON task.JobsJob_No = jobs.Job_No WHERE task.JobsJob_No="+system.getID();
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

                    getDiscountRate();
                    double subTotal = 0;

                    int numRows = 0;

                    while (rs.next()) {
                        String TaskID = rs.getString(1);
                        double Price = rs.getDouble(2);

                        numRows+=1;

                        row = s.createRow(numRows);
                        row.createCell(0).setCellValue(TaskID);
                        row.createCell(1).setCellValue(Price);
                        subTotal+=Price;

                    }

                    double total = (subTotal *discountRate*1.20);

                    row = s.createRow(numRows+1);
                    row.createCell(0).setCellValue("Sub-Total");
                    row.createCell(1).setCellValue(subTotal);

                    row = s.createRow(numRows+2);
                    row.createCell(0).setCellValue("Discount agreed:");
                    row.createCell(1).setCellValue(discountRate);

                    row = s.createRow(numRows+3);
                    row.createCell(0).setCellValue("Total Payable (VAT at 20%)");
                    row.createCell(1).setCellValue(String.format("%.2f",total));

                    FileOutputStream file = new FileOutputStream(new File("Customer Sales Report.xlsx"));
                    w.write(file);
                    file.close();
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

            public void getDiscountRate()
            {
                try
                {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);

                    String query = ("SELECT\n" +
                            "  discount.DiscountRate\n" +
                            "FROM jobs\n" +
                            "  INNER JOIN customer\n" +
                            "    ON jobs.CustomerAccount_No = customer.Account_No\n" +
                            "  INNER JOIN discount\n" +
                            "    ON discount.CustomerAccount_No = customer.Account_No\n" +
                            "WHERE Job_No = "+system.getID());
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet data = st.executeQuery(query);

                    while(data.next())
                    {
                       discountRate = data.getDouble(1);
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
