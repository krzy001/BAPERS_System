package Control;

import GUI.*;
import database.*;

import java.util.Stack;

public class BAPERS {

    //private final JFrame frame = new JFrame("BAPERS_SYSTEM");

    private Screen screen;
    private Control controller;
    private String currentPage;
    private Stack<String> pages = new Stack<String>();

    private String roleLoggedIn = "LoggedOff";

    public final String AddJob = "AJ";
    public final String AddPayment = "AP";
    public final String Backup = "B";
    public final String CreateCustomerAccount = "CCA";
    public final String CreateNewUser = "CNU";
    public final String IdentifyCustomer = "IC";
    public final String IdentifyUser = "IU";
    public final String IndividualJobReport = "IJR";
    public final String IndividualPerformanceReport = "IPR";
    public final String JobEnquiry = "JE";
    public final String JobList = "JL";
    public final String LogIn = "LI";
    public final String OfficeManager = "OM";
    public final String ShiftManager = "SM";
    public final String Receptionist = "R";
    public final String Technician = "T";
    public final String Reports = "RP";
    public final String Restore = "RS";
    public final String SummaryReport = "SR";
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

    public BAPERS(){
        dbConnection dbConnect = new dbConnection();
        dbConnect.DBConnectivity();
        currentPage = LogIn;
        controller = new Control();
        screen = new LogIn(this);
        screen.setSize(800,500);
        screen.setLocationRelativeTo(null);
    }

    public String getRoleLoggedIn(){
        return roleLoggedIn;
    }

    public void LogIn(String username, String password){
        roleLoggedIn = controller.login(this, username, password);

        if (roleLoggedIn != "LoggedOff"){
            nextScreen(roleLoggedIn);
        }
    }

    public void LogOut(){
        nextScreen(LogIn);
        pages.empty();
    }

    public Stack<String> getPages(){
        return pages;
    }

    public void nextScreen(String nextPage){
        pages.push(currentPage);
        setScreen(nextPage);
    }

    public void nextScreen(String nextPage, String info){
        pages.push(currentPage);
        setScreen(nextPage, info);
    }

    public void backScreen(){
        setScreen(pages.pop());
    }

    private void setScreen(String page){
        screen.setVisible(false);
        setCurrentPage(page);

        if(page == LogIn){
            screen = new LogIn(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == AddJob){
            screen = new AddJob(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == AddPayment){
            screen = new AddPayment(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == Backup){
            screen = new Backup(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == CreateCustomerAccount){
            screen = new CreateCustomerAccount(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == CreateNewUser){
            screen = new CreateNewUser(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == IdentifyCustomer){
            screen = new SearchCustomer(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == IdentifyUser){
            screen = new SearchUser(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == IndividualJobReport){
            screen = new IndividualJobReport(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == IndividualPerformanceReport) {
            screen = new IndividualPerformanceReport(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == JobEnquiry) {
            screen = new JobEnquiry(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == OfficeManager){
            screen = new OfficeManager(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if (page == Receptionist){
            screen = new Receptionist(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == Reports) {
            screen = new Reports(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == Restore) {
            screen = new Restore(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if (page == ShiftManager){
            screen = new ShiftManager(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == SummaryReport) {
            screen = new SummaryReport(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if (page == Technician) {
            screen = new Technician(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == UpdateCustomerInfo){
            screen = new UpdateCustomerInfo(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == UpdateUserInfo){
            screen = new UpdateUserInfo(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == AddTask){
            screen = new AddTask(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == SearchJob){
            screen = new SearchJob(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == SearchTask){
            screen = new SearchTask(this);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }

    }

    private void setScreen(String page, String info) {
        screen.setVisible(false);
        setCurrentPage(page);

        if(page == JobList) {
            screen = new JobsList(this, info);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == ViewCustomerAccount) {
            screen = new ViewCustomerAccount(this, info);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == ViewUserAccount) {
            screen = new ViewUserAccount(this, info);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);

        }
        else if(page == TaskList) {
            screen = new TaskList(this, info);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == ViewTask) {
            screen = new ViewTask(this, info);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }
        else if(page == ViewJob) {
            screen = new ViewJob(this, info);
            screen.setSize(800,500);
            screen.setLocationRelativeTo(null);
        }

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

    public static void main(String[] args){
        new BAPERS();
    }
}