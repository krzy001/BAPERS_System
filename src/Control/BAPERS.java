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

    public BAPERS(){
        dbConnection dbConnect = new dbConnection();
        dbConnect.DBConnectivity();
        currentPage = LogIn;
        controller = new Control();
        screen = new LogIn(this);
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

    public void backScreen(){
        setScreen(pages.pop());
    }

    private void setScreen(String page){
        screen.setVisible(false);
        setCurrentPage(page);

        //has to be done for every page.
        if(page == LogIn){
            screen = new LogIn(this);
        }
        else if(page == AddJob){
            screen = new AddJob(this);
        }
        else if(page == AddPayment){
            screen = new AddPayment(this);
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
            screen = new IdentifyCustomer(this);
        }
        else if(page == IdentifyUser){
            screen = new IdentifyUser(this);
        }
        else if(page == IndividualJobReport){
            screen = new IndividualJobReport(this);
        }
        else if(page == IndividualPerformanceReport) {
            screen = new IndividualPerformanceReport(this);
        }
        else if(page == JobEnquiry) {
            screen = new JobEnquiry(this);
        }
        else if(page == JobList) {
            screen = new JobsList(this);
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
        else if(page == SummaryReport) {
            screen = new SummaryReport(this);
        }
        else if (page == Technician){
            screen = new Technician(this);
        }
        else if(page == ViewCustomerAccount) {
            screen = new ViewCustomerAccount(this);
        }
        else if(page == ViewUserAccount) {
            screen = new ViewUserAccount(this);
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