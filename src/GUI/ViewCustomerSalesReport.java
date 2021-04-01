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

        //Font and size of buttons established for the interface
        float logo = 80;
        labelLogo.setFont(labelLogo.getFont().deriveFont(logo));
        labelLogo.setForeground(Color.RED);

        btnLogout.setPreferredSize(new Dimension(150,30));
        btnBack.setPreferredSize(new Dimension(150,30));
        printButton.setPreferredSize(new Dimension(150,30));

        //Model is created to be displayed on screen
        DefaultTableModel model = system.generateCustomerSalesReport();
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

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, user, pass);
                    //Select all the relevant attributes from task
                    //uses the job ID from tasks to match with the job ID from jobs
                    //Where Job ID is equal to what the user requested
                    String sql = "SELECT task.Task_ID,task.Price FROM task INNER JOIN jobs ON task.JobsJob_No = jobs.Job_No WHERE task.JobsJob_No="+system.getID();
                    PreparedStatement pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(sql);

                    //Workbook created to be put in a file for excel sheet
                    Workbook w = new XSSFWorkbook();

                    Sheet s = w.createSheet("Customer Sales Report");
                    //Headers established for the report
                    String[] headers = {"Task Id", "Price"};
                    Row row = s.createRow(0);

                    //Headers added as a row
                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = row.createCell(i);
                        cell.setCellValue(headers[i]);
                    }

                    //Get the discount rate of the customer to be used
                    getDiscountRate();
                    double subTotal = 0;

                    int numRows = 0;

                    //For every row of attributes..
                    while (rs.next()) {
                        //Variables used to save attributes
                        String TaskID = rs.getString(1);
                        double Price = rs.getDouble(2);

                        numRows+=1;

                        //a row is created and the variables are added as cells
                        row = s.createRow(numRows);
                        row.createCell(0).setCellValue(TaskID);
                        row.createCell(1).setCellValue(Price);
                        subTotal+=Price;

                    }

                    //A total is calculated
                    double total = (subTotal *discountRate*1.20);

                    //Rows are added at the bottom of the report to display sub-total, discount rate and final total
                    row = s.createRow(numRows+1);
                    row.createCell(0).setCellValue("Sub-Total");
                    row.createCell(1).setCellValue(subTotal);

                    row = s.createRow(numRows+2);
                    row.createCell(0).setCellValue("Discount agreed:");
                    row.createCell(1).setCellValue(discountRate);

                    row = s.createRow(numRows+3);
                    row.createCell(0).setCellValue("Total Payable (VAT at 20%)");
                    row.createCell(1).setCellValue(String.format("%.2f",total));

                    //File is created, the workbook is written into the file, and the file is closed
                    FileOutputStream file = new FileOutputStream(new File("Customer Sales Report.xlsx"));
                    w.write(file);
                    file.close();
                }
                catch(Exception e1){
                    JOptionPane.showMessageDialog(null,"Error Occurred");
                }
            }

            //A method to retrieve the discount rate of a customer
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
                    JOptionPane.showMessageDialog(null,"Error Occurred");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
