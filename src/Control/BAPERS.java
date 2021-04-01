package Control;

import GUI.*;
import Report.*;
import database.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Stack;

public class BAPERS {

    //private final JFrame frame = new JFrame("BAPERS_SYSTEM");

    //Important global variables.
    private Screen screen; // The "screen" of the system. Changes for each screen the user enters
    private Report report; // Report object. Used to generate reports to be viewed on screen
    private Control controller; // Control class as an object. used for certain sql tasks used by GUI
    private String currentPage; // Used to store the current page the user is on. Helps to keep track of user's history on system
    private Stack<String> pages = new Stack<String>(); // Keeps track of user's history on system.
    private String ID; // Stores whatever ID is being used to search the database
    ArrayList<String> urgentJobs = new ArrayList<String>(); // List of urgent job IDs that needs to be shown to the office manager
    private boolean urgentJobsShown = false; // Has the urgent jobs list been shown

    // What role has logged into the system
    private String roleLoggedIn = "LoggedOff";

    //Variables used to label pages of the system.
    public final String AddJob = "AJ";
    public final String AddPayment = "AP";
    public final String Backup = "B";
    public final String CreateCustomerAccount = "CCA";
    public final String CreateNewUser = "CNU";
    public final String IdentifyCustomer = "IC";
    public final String IdentifyUser = "IU";
    public final String ViewCustomerSalesReport = "VCSR";
    public final String ViewIndividualPerformanceReport = "VIPR";
    public final String JobEnquiry = "JE";
    public final String JobList = "JL";
    public final String JobListTech = "JLT";
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
    public final String TaskListTech = "TLT";
    public final String SearchJob = "SJ";
    public final String SearchJobTech = "SJT";
    public final String SearchTask = "ST";
    public final String SearchTaskTech = "STT";
    public final String ViewJob = "VJ";
    public final String ViewJobTech = "VJT";
    public final String ViewTask = "VT";
    public final String ViewTaskTech = "VTT";
    public final String RecordCardPayment = "RCP";
    public final String RecordCashPayment = "RCHP";
    public final String UrgentJobsList = "UJL";
    public final String Discount = "D";
    public final String EnterJobID = "EJID";
    public final String SearchPayment = "SP";
    public final String ViewPayment = "VP";
    public final String PaymentList = "PL";
    public final String StaffList = "SL";
    public final String UpdateJob ="UJ";
    public final String UpdateTask ="UT";

    // When BAPERS object is created, database connection is established.
    // Some important variables/objects are also established.
    // Screen size established.
    public BAPERS(){
        dbConnection dbConnect = new dbConnection();
        dbConnect.DBConnectivity();
        currentPage = LogIn;
        controller = new Control();
        screen = new LogIn(this);
        screen.setSize(1000,800);
        screen.setLocationRelativeTo(null);
    }

    // Method to log out the system
    public void LogOut(){
        nextScreen(LogIn); // Go to log in page
        pages.empty(); // Empties user's history with system
        setRoleLoggedIn("LoggedOff"); // Sets the role logged in to logged off
        setUrgentJobsShown(false);
        urgentJobs = new ArrayList<String>();
    }

    //Go to the next screen of the system (Whatever the user has selected.
    public void nextScreen(String nextPage){
        pages.push(currentPage); //Push whatever the current page was onto the stack to save as history
        setScreen(nextPage); // Set the screen to the next page
    }

    public void backScreen(){
        setScreen(pages.pop()); //Pop the last page entered onto the screen out and set that screen
    }

    //Sets the screen to whatever page has been fed. One if statement per page
    private void setScreen(String page){
        screen.setVisible(false); //The last page goes away for the new page
        setCurrentPage(page); // Set the new page as the current page

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
        else if(page == ViewCustomerSalesReport){
            screen = new ViewCustomerSalesReport(this);
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
        else if(page == UrgentJobsList){
            screen = new UrgentJobsList(this);
        }
        else if(page == Discount){
            screen = new Discount(this);
        }
        else if(page == EnterJobID) {
            screen = new EnterJobID(this);
        }
        else if(page == PaymentList){
            screen = new PaymentList(this);
        }
        else if(page == SearchPayment){
            screen = new SearchPayment(this);
        }
        else if(page == ViewPayment){
            screen = new ViewPayment(this);
        }
        else if(page == StaffList){
            screen = new StaffList(this);
        }
        else if(page == UpdateJob){
            screen = new UpdateJob(this);
        }
        else if(page == UpdateTask){
            screen = new UpdateTask(this);
        }
        else if(page == JobListTech){
            screen = new JobListTech(this);
        }
        else if(page == TaskListTech){
            screen = new TaskListTech(this);
        }
        else if(page == SearchJobTech){
            screen = new SearchJobTech(this);
        }
        else if(page == SearchTaskTech){
            screen = new SearchTaskTech(this);
        }
        else if(page == ViewJobTech){
            screen = new ViewJobTech(this);
        }
        else if(page == ViewTaskTech){
            screen = new ViewTaskTech(this);
        }

        //Reset the size and location of the screen
        screen.setSize(1000, 800);
        screen.setLocationRelativeTo(null);
    }

    // creates a new individual performance report under report object to return to GUI for it to be displayed on screen
    public DefaultTableModel generateIndividualPerformanceReport(){
        report = new Report();
        report.getIndividualPerformanceReport(this);

        return report.getModel();
    }

    // creates a new summary report under report object to return to GUI for it to be displayed on screen
    public DefaultTableModel generateSummaryReport(){
        report = new Report();
        report.getSummaryReport(this);

        return report.getModel();
    }

    // creates a new customer sales report under report object to return to GUI for it to be displayed on screen
    public DefaultTableModel generateCustomerSalesReport(){
        report = new Report();
        report.getCustomerSalesReport(this);

        return report.getModel();
    }

    //Return the controller object. Mainly used by GUI screens that need to save information onto the database
    public Control getController(){
        return controller;
    }

    //set the current page the system is on
    public void setCurrentPage(String currentPage){
        this.currentPage = currentPage;
    }

    //return the ID that is needed to get certain data from the database
    public String getID(){
        return ID;
    }

    //Set an ID that'll later be used to get certain data from the database
    public void setID(String ID){
        this.ID = ID;
    }

    //Set the role that is logged into the system
    public void setRoleLoggedIn(String role) {
        roleLoggedIn = role;
    }

    //Return the list of urgent jobs IDs that need to be shown to the office manager
    public ArrayList<String> getUrgentJobs() {
        return urgentJobs;
    }

    //Add a job the the list of urgent jobs that need to be shown to the office manager
    public void addUrgentJobs(String jobID){
        urgentJobs.add(jobID);
    }

    //If urgents jobs is already shown, it doesnt need to be shown again.
    public boolean isUrgentJobsShown(){
        return urgentJobsShown;
    }

    //Set to true once the urgent jobs list has been shown
    public void setUrgentJobsShown(boolean bool){
        urgentJobsShown = bool;
    }

    //Main method: this is where the system begins. Creates a new BAPERS object.
    public static void main(String[] args){
        new BAPERS();
    }
}