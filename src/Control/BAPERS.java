package Control;

import GUI.*;

import javax.swing.*;
import java.util.Stack;

public class BAPERS {

    //private final JFrame frame = new JFrame("BAPERS_SYSTEM");

    private Screen screen;
    private Control controller;
    private String currentPage;
    private Stack<String> pages = new Stack<String>();

    private String roleLoggedIn;

    // Considering using these instead of Strings for optimisation
    private final String AddJob = "AJ";
    private final String AddPayment = "AP";
    private final String Backup = "B";
    private final String CreateCustomerAccount = "CCA";
    private final String CreateNewUser = "CNU";
    private final String IdentifyCustomer = "IC";
    private final String IdentifyUser = "IU";
    private final String IndividualJobReport = "IJR";
    private final String IndividualPerformanceReport = "IPR";
    private final String JobEnquiry = "JE";
    private final String JobList = "JL";
    private final String LogIn = "LI";
    private final String OfficeManager = "OM";
    private final String ShiftManager = "SM";
    private final String Receptionist = "R";
    private final String Technician = "T";
    private final String Reports = "RP";
    private final String Restore = "RS";
    private final String Screen = "S";
    private final String SummaryReport = "SR";
    private final String ViewCustomerAccount = "VCA";
    private final String ViewUserAccount = "VUA";

    public BAPERS(){
        currentPage = LogIn;
        controller = new Control();
        screen = new LogIn(this, controller);
    }

    public String getRoleLoggedIn(){
        return roleLoggedIn;
    }

    public void LoggingIn(String role){
        roleLoggedIn = role;
        nextScreen(roleLoggedIn);
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
            screen = new LogIn(this, controller);
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
        else if(page == Screen) {
            screen = new Screen(this);
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