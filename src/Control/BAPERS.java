package Control;

import GUI.*;

import javax.swing.*;
import java.util.Stack;

public class BAPERS {

    //private final JFrame frame = new JFrame("BAPERS_SYSTEM");

    private Screen screen;
    private Control controller;
    private Stack<String> pages = new Stack<String>();

    private String roleLoggedIn;

    // Considering using these instead of Strings for optimisation
    private final String AddJob = "AJ";
    private final String AddPayment = "AP";
    private final String Backup = "B";
    private final String CreateCustomerAccount = "CCA";

    private final String OfficeManager = "OM";
    private final String ShiftManager = "SM";
    private final String Receptionist = "R";
    private final String Technician = "T";



    public BAPERS(){
        controller = new Control();
        screen = new LogIn(this, controller);
    }

    public String getRoleLoggedIn(){
        return roleLoggedIn;
    }

    public void LoggingIn(String role){
        roleLoggedIn = role;
        nextScreen("LogIn", roleLoggedIn);
    }

    public void nextScreen(String lastPage, String nextPage){
        pages.push(lastPage);
        setScreen(nextPage);
    }

    public void backScreen(){
        setScreen(pages.pop());
    }

    private void setScreen(String page){
        screen.setVisible(false);

        //has to be done for every page.
        if(page == "LogIn"){
            screen = new LogIn(this, controller);
        }
        else if(page == "OfficeManager"){
            screen = new OfficeManager(this);
        }
        else if (page == "ShiftManager"){
            screen = new ShiftManager(this);
        }
        else if (page == "Receptionist"){
            screen = new Receptionist(this);
        }
        else if (page == "Technician"){
            screen = new Technician(this);
        }
    }

    public static void main(String[] args){
        new BAPERS();
    }
}