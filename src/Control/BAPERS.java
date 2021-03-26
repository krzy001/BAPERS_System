package Control;

import GUI.*;
import Report.*;
import database.*;

import javax.swing.table.DefaultTableModel;
import java.util.Stack;

public class BAPERS {

    //private final JFrame frame = new JFrame("BAPERS_SYSTEM");

    private Screen screen;
    private Report report;
    private Control controller;
    private String currentPage;
    private String ID;
    private Stack<String> pages = new Stack<String>();

    private String roleLoggedIn = "LoggedOff";


    public final String AddJob = "AJ";
    public final String AddPayment = "AP";
    public final String Backup = "B";
    public final String CreateCustomerAccount = "CCA";
    public final String CreateNewUser = "CNU";
    public final String IdentifyCustomer = "IC";
    public final String IdentifyUser = "IU";
    public final String ViewIndividualJobReport = "VIJR";
    public final String ViewIndividualPerformanceReport = "VIPR";
    public final String JobEnquiry = "JE";
    public final String JobList = "JL";
    public final String LogIn = "LI";
    public final String OfficeManager = "Office Manager";
    public final String ShiftManager = "Shift Manager";
    public final String Receptionist = "Receptionist";
    public final String Technician = "Technician";
    public final String Reports = "RP";
    public final String Restore = "RS";
    public final String ViewSummaryReport = "VSR";
    public final String ViewCustomerAccount = "VCA";
    public final String ViewUserAccount = "VUA";
    public final String UpdateCustomerInfo = "UCI";
    public final String UpdateUserInfo = "UUI";
    public final String AddTask = "ADT";
    public final String TaskList = "TL";
    public final String SearchJob = "SJ";
    public final String SearchTask = "ST";
    public final String ViewJob = "VJ";
    public final String ViewTask = "VT";
    public final String RecordCardPayment = "RCP";
    public final String RecordCashPayment = "RCHP";

    public BAPERS(){
        dbConnection dbConnect = new dbConnection();
        dbConnect.DBConnectivity();
        currentPage = LogIn;
        controller = new Control();
        screen = new LogIn(this);
        screen.setSize(1000,800);
        screen.setLocationRelativeTo(null);
    }

    public String getRoleLoggedIn(){
        return roleLoggedIn;
    }

   /* public void LogIn(String text, String username, String password){
        controller.login(this, username, password);

        if (roleLoggedIn != "LoggedOff"){
            nextScreen(roleLoggedIn);
        }
    }*/

    public void LogOut(){
        nextScreen(LogIn);
        pages.empty();
        setRoleLoggedIn("LoggedOff");
    }

    public Stack<String> getPages(){
        return pages;
    }

    public void nextScreen(String nextPage){
        pages.push(currentPage);
        setScreen(nextPage);
    }

    public void backScreen(){
        setScreen(pages.pop());
    }

    private void setScreen(String page){
        screen.setVisible(false);
        setCurrentPage(page);

        if(page == LogIn){
            screen = new LogIn(this);
        }
        else if(page == AddJob){
            screen = new AddJob(this);
        }
        else if(page == Backup){
            screen = new Backup(this);
        }
        else if(page == CreateCustomerAccount){
            screen = new CreateCustomerAccount(this);
        }
        else if(page == CreateNewUser){
            screen = new CreateNewUser(this);
        }
        else if(page == IdentifyCustomer){
            screen = new SearchCustomer(this);
        }
        else if(page == IdentifyUser){
            screen = new SearchUser(this);
        }
        else if(page == ViewIndividualJobReport){
            screen = new ViewIndividualJobReport(this);
        }
        else if(page == ViewIndividualPerformanceReport) {
            screen = new ViewIndividualPerformanceReport(this);
        }
        else if(page == JobEnquiry) {
            screen = new JobEnquiry(this);
        }
        else if(page == OfficeManager){
            screen = new OfficeManager(this);
        }
        else if (page == Receptionist){
            screen = new Receptionist(this);
        }
        else if(page == Reports) {
            screen = new Reports(this);
        }
        else if(page == Restore) {
            screen = new Restore(this);
        }
        else if (page == ShiftManager){
            screen = new ShiftManager(this);
        }
        else if(page == ViewSummaryReport) {
            screen = new ViewSummaryReport(this);
        }
        else if (page == Technician) {
            screen = new Technician(this);
        }
        else if(page == UpdateCustomerInfo){
            screen = new UpdateCustomerInfo(this);
        }
        else if(page == UpdateUserInfo){
            screen = new UpdateUserInfo(this);
        }
        else if(page == AddTask){
            screen = new AddTask(this);
        }
        else if(page == SearchJob){
            screen = new SearchJob(this);
        }
        else if(page == SearchTask){
            screen = new SearchTask(this);
        }
        else if(page == JobList) {
            screen = new JobsList(this);
        }
        else if(page == TaskList) {
            screen = new TaskList(this);
        }
        else if(page == ViewCustomerAccount) {
            screen = new ViewCustomerAccount(this);
        }
        else if(page == ViewUserAccount) {
            screen = new ViewUserAccount(this);
        }
        else if(page == ViewTask) {
            screen = new ViewTask(this);
        }
        else if(page == ViewJob) {
            screen = new ViewJob(this);
        }
        else if(page == RecordCardPayment) {
            screen = new RecordCardPayment(this);
        }
        else if(page == RecordCashPayment) {
            screen = new RecordCashPayment(this);
        }
        else if(page == AddPayment){
            screen = new AddPayment(this);
        }
        screen.setSize(1000,800);
        screen.setLocationRelativeTo(null);
    }

    public DefaultTableModel generateIndividualPerformanceReport(){
        report = new Report();
        report.getIndividualPerformanceReport();

        return report.getModel();
    }

    public DefaultTableModel generateSummaryReport(){
        report = new Report();
        return report.getModel();
    }

    public Control getController(){
        return controller;
    }

    public void setCurrentPage(String currentPage){
        this.currentPage = currentPage;
    }

    public String getCurrentPage(){
        return currentPage;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public static void main(String[] args){
        new BAPERS();
    }

    public void setRoleLoggedIn(String role) {
        roleLoggedIn = role;
    }
}